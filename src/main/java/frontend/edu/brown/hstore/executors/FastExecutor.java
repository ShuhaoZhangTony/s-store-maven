package frontend.edu.brown.hstore.executors;

import frontend.voltdb.VoltTable;
import frontend.voltdb.catalog.PlanFragment;

import frontend.edu.brown.hstore.PartitionExecutor;
import frontend.edu.brown.hstore.txns.LocalTransaction;

public abstract class FastExecutor {

    protected final PartitionExecutor executor;
    
    /**
     * Constructor
     * @param executor
     */
    public FastExecutor(PartitionExecutor executor) {
        this.executor = executor;
    }
    
    /**
     * Execute a Java-only operation to generate the output of a PlanFragment for 
     * the given transaction without needing to go down in to ExecutionEngine
     * @param ts 
     * @param catalog_frag
     * @param input
     * @return
     */
    public abstract VoltTable execute(LocalTransaction ts, PlanFragment catalog_frag, VoltTable input[]);
    
}
