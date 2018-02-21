package benchmarks.org.voltdb.benchmark.tpcc.procedures;

import java.util.HashMap;
import java.util.Map.Entry;

import frontend.voltdb.ProcInfo;
import frontend.voltdb.SQLStmt;
import frontend.voltdb.VoltProcedure;
import frontend.voltdb.VoltTable;
import frontend.voltdb.VoltType;

@ProcInfo(
    singlePartition = false
)
public class UpdateOrderLine extends VoltProcedure {
    
    public SQLStmt query = new SQLStmt(
            "UPDATE order_line SET ol_quantity = ol_quantity + 1 WHERE ol_o_id = 100"
    );
    
    
    public VoltTable[] run() {
	    voltQueueSQL(query);
	    VoltTable v[] = voltExecuteSQL();
	    
	    // Assume the update always succeed.
	    return v;
    }
    
}
