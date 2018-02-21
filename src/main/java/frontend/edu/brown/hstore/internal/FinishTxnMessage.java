package frontend.edu.brown.hstore.internal;

import protorpc.edu.brown.hstore.Hstoreservice.Status;
import frontend.edu.brown.hstore.txns.AbstractTransaction;

public class FinishTxnMessage extends InternalTxnMessage {
    
    private Status status;
    
    public FinishTxnMessage(AbstractTransaction ts, Status status) {
        super(ts);
        this.status = status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Status getStatus() {
        return (this.status);
    }

}
