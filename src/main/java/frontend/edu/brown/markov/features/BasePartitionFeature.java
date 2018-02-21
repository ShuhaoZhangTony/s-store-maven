package frontend.edu.brown.markov.features;

import frontend.voltdb.catalog.Procedure;

import frontend.edu.brown.hstore.HStoreConstants;
import frontend.edu.brown.markov.FeatureSet;
import frontend.edu.brown.markov.FeatureSet.Type;
import frontend.edu.brown.utils.PartitionEstimator;
import frontend.edu.brown.workload.TransactionTrace;

/**
 * Extract the base partition for the txn
 * @author pavlo
 */
public class BasePartitionFeature extends AbstractFeature {
    
    public BasePartitionFeature(PartitionEstimator p_estimator, Procedure catalog_proc) {
        super(p_estimator, catalog_proc, BasePartitionFeature.class);
    }

    @Override
    public void extract(FeatureSet fset, TransactionTrace txn_trace) throws Exception {
        String key = this.getFeatureKey();
        Object val = this.calculate(key, txn_trace);
        fset.addFeature(txn_trace, key, val, Type.NUMERIC);
    }
    
    @Override
    public Object calculate(String key, Object params[]) throws Exception {
        int partition = this.p_estimator.getBasePartition(this.catalog_proc, params);
        return (partition != HStoreConstants.NULL_PARTITION_ID ? partition : null);
    }

}
