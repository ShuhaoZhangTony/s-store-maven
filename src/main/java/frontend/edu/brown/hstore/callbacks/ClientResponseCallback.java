/**
 * 
 */
package frontend.edu.brown.hstore.callbacks;

import frontend.voltdb.ClientResponseImpl;
import frontend.voltdb.exceptions.ClientConnectionLostException;
import frontend.voltdb.network.Connection;

import com.google.protobuf.RpcCallback;

import frontend.edu.brown.hstore.ClientInterface;

/**
 * Thin wrapper to sent a ClientResponse back to the client over a Connection handle
 * @author pavlo
 */
public class ClientResponseCallback implements RpcCallback<ClientResponseImpl> {

    private final ClientInterface clientInterface;
    private final Connection conn;
    private final int messageSize;
    
    public ClientResponseCallback(ClientInterface clientInterface, Connection conn, int messageSize) {
        this.clientInterface = clientInterface;
        this.conn = conn;
        this.messageSize = messageSize;
    }
    
    
    @Override
    public void run(ClientResponseImpl parameter) {
        // Always reduce backpressure before we throw the exception
        boolean ret = this.conn.writeStream().enqueue(parameter);
        this.clientInterface.reduceBackpressure(this.messageSize);
        if (ret == false) {
            throw new ClientConnectionLostException(parameter.getTransactionId());
        }
    }
    
    public String toString() {
        return (this.conn.toString());
    }

}
