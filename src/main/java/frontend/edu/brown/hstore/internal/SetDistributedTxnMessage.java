package frontend.edu.brown.hstore.internal;

import frontend.edu.brown.hstore.txns.AbstractTransaction;

/**
 * This is used to indicate to the PartitionExecutor which dtxn
 * currently has the lock for its partition.
 * @author pavlo
 */
public class SetDistributedTxnMessage extends InternalTxnMessage {

    public SetDistributedTxnMessage (AbstractTransaction txn) {
        super(txn);
    }
}
