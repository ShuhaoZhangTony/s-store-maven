package frontend.edu.brown.hstore.dispatchers;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;

import frontend.edu.brown.hstore.HStoreCoordinator;
import frontend.edu.brown.hstore.HStoreSite;
import protorpc.edu.brown.hstore.Hstoreservice.TransactionInitRequest;
import protorpc.edu.brown.hstore.Hstoreservice.TransactionInitResponse;

public class TransactionInitDispatcher extends AbstractDispatcher<Object[]> {
    
    public TransactionInitDispatcher(HStoreSite hstore_site, HStoreCoordinator hstore_coordinator) {
        super(hstore_site, hstore_coordinator);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void runImpl(Object o[]) {
        RpcController controller = (RpcController)o[0];
        TransactionInitRequest request = (TransactionInitRequest)o[1];
        RpcCallback<TransactionInitResponse> callback = (RpcCallback<TransactionInitResponse>)o[2];
        hstore_coordinator.getTransactionInitHandler().remoteHandler(controller, request, callback);
    }

}
