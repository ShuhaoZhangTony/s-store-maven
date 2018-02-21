package frontend.voltdb.sysprocs;

import java.util.List;
import java.util.Map;

import frontend.voltdb.DependencySet;
import frontend.voltdb.ParameterSet;
import frontend.voltdb.ProcInfo;
import frontend.voltdb.VoltSystemProcedure;
import frontend.voltdb.VoltTable;

import frontend.edu.brown.hstore.HStoreConstants;
import frontend.edu.brown.hstore.PartitionExecutor.SystemProcedureExecutionContext;

@ProcInfo(singlePartition = false)
public class NoOp extends VoltSystemProcedure {

    @Override
    public void initImpl() {
        // Nothing
    }
    
    @Override
    public DependencySet executePlanFragment(Long txnId, Map<Integer, List<VoltTable>> dependencies, int fragmentId, ParameterSet params, SystemProcedureExecutionContext context) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public VoltTable[] run() {
        return HStoreConstants.EMPTY_RESULT;
    }

}
