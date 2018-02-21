package frontend.edu.brown.hstore.internal;

import protorpc.edu.brown.hstore.Hstoreservice.WorkFragment;
import frontend.edu.brown.hstore.txns.AbstractTransaction;

public class WorkFragmentMessage extends InternalTxnMessage {
    
    private WorkFragment fragment;
    
    public WorkFragmentMessage(AbstractTransaction ts, WorkFragment fragment) {
        super(ts);
        this.fragment = fragment;
    }

    public void setFragment(WorkFragment fragment) {
        this.fragment = fragment;
    }
    
    public WorkFragment getFragment() {
        return (this.fragment);
    }
}
