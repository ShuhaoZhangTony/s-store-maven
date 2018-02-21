package frontend.voltdb.sysprocs;

import java.util.List;
import java.util.Map;

import frontend.voltdb.exceptions.ServerFaultException;
import frontend.voltdb.types.TimestampType;
import frontend.voltdb.utils.VoltTableUtil;
import frontend.voltdb.exceptions.ServerFaultException;
import frontend.voltdb.types.TimestampType;
import frontend.voltdb.utils.VoltTableUtil;
import org.apache.log4j.Logger;
import frontend.voltdb.DependencySet;
import frontend.voltdb.ParameterSet;
import frontend.voltdb.ProcInfo;
import frontend.voltdb.VoltSystemProcedure;
import frontend.voltdb.VoltTable;
import frontend.voltdb.VoltTable.ColumnInfo;
import frontend.voltdb.VoltType;
import frontend.voltdb.exceptions.ServerFaultException;
import frontend.voltdb.types.TimestampType;
import frontend.voltdb.utils.VoltTableUtil;

import frontend.edu.brown.hstore.PartitionExecutor;
import frontend.edu.brown.profilers.ProfileMeasurement;

/** 
 * Force the garbage collector run at each HStoreSite
 */
@ProcInfo(singlePartition = false)
public class GarbageCollection extends VoltSystemProcedure {
    private static final Logger LOG = Logger.getLogger(GarbageCollection.class);

    public static final ColumnInfo nodeResultsColumns[] = {
        new ColumnInfo("SITE", VoltType.STRING),
        new ColumnInfo("ELAPSED", VoltType.INTEGER),
        new ColumnInfo("CREATED", VoltType.TIMESTAMP),
    };
    
    private final ProfileMeasurement gcTime = new ProfileMeasurement(this.getClass().getSimpleName());

    @Override
    public void initImpl() {
        executor.registerPlanFragment(SysProcFragmentId.PF_gcAggregate, this);
        executor.registerPlanFragment(SysProcFragmentId.PF_gcDistribute, this);
    }

    @Override
    public DependencySet executePlanFragment(Long txn_id,
                                             Map<Integer, List<VoltTable>> dependencies,
                                             int fragmentId,
                                             ParameterSet params,
                                             PartitionExecutor.SystemProcedureExecutionContext context) {
        DependencySet result = null;
        switch (fragmentId) {
            // Perform Garbage Collection
            case SysProcFragmentId.PF_gcDistribute: {
                LOG.debug("Invoking garbage collector");
                this.gcTime.clear();
                this.gcTime.start();
                // System.gc();
                this.gcTime.stop();
                
                if (LOG.isDebugEnabled())
                    LOG.debug(String.format("Performed Garbage Collection at %s: %s",
                              this.executor.getHStoreSite().getSiteName(),
                              this.gcTime.debug()));
                VoltTable vt = new VoltTable(nodeResultsColumns);
                vt.addRow(this.executor.getHStoreSite().getSiteName(),
                          (int)this.gcTime.getTotalThinkTimeMS(),
                          new TimestampType());
                result = new DependencySet(SysProcFragmentId.PF_gcDistribute, vt);
                break;
            }
            // Aggregate Results
            case SysProcFragmentId.PF_gcAggregate:
                LOG.debug("Combining results");
                List<VoltTable> siteResults = dependencies.get(SysProcFragmentId.PF_gcDistribute);
                if (siteResults == null || siteResults.isEmpty()) {
                    String msg = "Missing site results";
                    throw new ServerFaultException(msg, txn_id);
                }
                
                VoltTable vt = VoltTableUtil.union(siteResults);
                result = new DependencySet(SysProcFragmentId.PF_gcAggregate, vt);
                break;
            default:
                String msg = "Unexpected sysproc fragmentId '" + fragmentId + "'";
                throw new ServerFaultException(msg, txn_id);
        } // SWITCH
        // Invalid!
        return (result);
    }
    
    public VoltTable[] run() {
        return this.executeOncePerSite(SysProcFragmentId.PF_gcDistribute,
                                       SysProcFragmentId.PF_gcAggregate);
    }
}
