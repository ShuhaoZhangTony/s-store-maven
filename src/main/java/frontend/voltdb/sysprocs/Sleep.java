package frontend.voltdb.sysprocs;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import frontend.voltdb.DependencySet;
import frontend.voltdb.ParameterSet;
import frontend.voltdb.ProcInfo;
import frontend.voltdb.VoltSystemProcedure;
import frontend.voltdb.VoltTable;

import frontend.edu.brown.hstore.HStoreConstants;
import frontend.edu.brown.hstore.PartitionExecutor.SystemProcedureExecutionContext;
import frontend.edu.brown.utils.ThreadUtil;

@ProcInfo(singlePartition = false)
public class Sleep extends VoltSystemProcedure {
    private static final Logger LOG = Logger.getLogger(Sleep.class);
    
    @Override
    public void initImpl() {
        // Nothing
    }
    
    @Override
    public DependencySet executePlanFragment(Long txnId,
                                             Map<Integer,
                                             List<VoltTable>> dependencies,
                                             int fragmentId,
                                             ParameterSet params,
                                             SystemProcedureExecutionContext context) {
        // This should never get invoked
        return null;
    }
    
    public VoltTable[] run(long sleepTime, VoltTable data[]) {
        
        LOG.debug(String.format("BEFORE: Sleeping for %.01f seconds", sleepTime / 1000d));
        ThreadUtil.sleep(sleepTime);
        LOG.debug("BEFORE: Awake!");
        
        return HStoreConstants.EMPTY_RESULT;
    }
}
