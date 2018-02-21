package frontend.edu.brown.hstore.dispatchers;

import java.nio.ByteBuffer;

import frontend.voltdb.utils.Pair;

import frontend.edu.brown.hstore.HStoreCoordinator;
import frontend.edu.brown.hstore.HStoreSite;
import frontend.edu.brown.hstore.callbacks.TransactionRedirectResponseCallback;

/**
 * 
 */
public class TransactionRedirectDispatcher extends AbstractDispatcher<Pair<ByteBuffer, TransactionRedirectResponseCallback>> {
    
    public TransactionRedirectDispatcher(HStoreSite hstore_site, HStoreCoordinator hstore_coordinator) {
        super(hstore_site, hstore_coordinator);
    }

    @Override
    public void runImpl(Pair<ByteBuffer, TransactionRedirectResponseCallback> p) {
        this.hstore_site.invocationProcess(p.getFirst(), p.getSecond());
    }
}