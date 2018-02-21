package benchmarks.org.voltdb.benchmark.tpcc.procedures;

import frontend.voltdb.ProcInfo;
import frontend.voltdb.VoltProcedure;
import frontend.voltdb.VoltTable;
import frontend.voltdb.types.TimestampType;

/**
 * NewOrder NoOp
 * @author pavlo
 */
@ProcInfo (
    partitionInfo = "WAREHOUSE.W_ID: 0",
    singlePartition = false
)
public class noop extends VoltProcedure {

    public VoltTable[] run(short w_id, byte d_id, int c_id, TimestampType timestamp, int[] item_id, short[] supware, int[] quantity) throws VoltAbortException {
        assert item_id.length > 0;
        assert item_id.length == supware.length;
        assert item_id.length == quantity.length;

        return new VoltTable[0];
    }
}
