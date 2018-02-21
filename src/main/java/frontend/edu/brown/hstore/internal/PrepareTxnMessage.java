package frontend.edu.brown.hstore.internal;

import frontend.edu.brown.hstore.callbacks.PartitionCountingCallback;
import frontend.edu.brown.hstore.txns.AbstractTransaction;

/**
 * This message is used to indicate that the transaction as finished at 
 * this partition. 
 * @author pavlo
 */
public class PrepareTxnMessage extends InternalTxnMessage {
    
    private final PartitionCountingCallback<? extends AbstractTransaction> callback;
    
    public PrepareTxnMessage(AbstractTransaction ts, PartitionCountingCallback<? extends AbstractTransaction> callback) {
        super(ts);
        this.callback = callback;
    }
    
    public PartitionCountingCallback<? extends AbstractTransaction> getCallback() {
        return (this.callback);
    }
}
