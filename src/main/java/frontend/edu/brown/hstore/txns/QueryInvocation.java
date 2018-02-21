package frontend.edu.brown.hstore.txns;

import frontend.voltdb.catalog.Statement;

import frontend.edu.brown.utils.PartitionSet;

public class QueryInvocation {
    public final Statement stmt;
    public final int counter;
    public final PartitionSet partitions;
    public final int paramsHash;
    
    public QueryInvocation(Statement stmt, int counter, PartitionSet partitions, int paramsHash) {
        this.stmt = stmt;
        this.counter = counter;
        this.partitions = partitions;
        this.paramsHash = paramsHash;
    }
}