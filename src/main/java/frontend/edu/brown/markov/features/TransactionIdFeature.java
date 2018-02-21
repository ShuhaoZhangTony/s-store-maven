package frontend.edu.brown.markov.features;

import frontend.voltdb.catalog.Procedure;

import frontend.edu.brown.markov.FeatureSet;
import frontend.edu.brown.utils.PartitionEstimator;
import frontend.edu.brown.workload.TransactionTrace;

/**
 * 
 * @author pavlo
 */
public class TransactionIdFeature extends AbstractFeature {

    public TransactionIdFeature(PartitionEstimator p_estimator, Procedure catalog_proc) {
        super(p_estimator, catalog_proc, TransactionIdFeature.class);
    }

    
    @Override
    public void extract(FeatureSet fset, TransactionTrace txnTrace) throws Exception {
        // Important! We have to store the txn id as a string because there are rounding issues
        // when we try to extract it back out!
        fset.addFeature(txnTrace, this.getFeatureKey(), Long.toString(txnTrace.getTransactionId()));
    }
    
    @Override
    public Object calculate(String key, TransactionTrace txnTrace) throws Exception {
        return txnTrace.getTransactionId();
    }
    
    @Override
    public Object calculate(String key, Object params[]) throws Exception {
        assert(false);
        return (null);
    }

}
