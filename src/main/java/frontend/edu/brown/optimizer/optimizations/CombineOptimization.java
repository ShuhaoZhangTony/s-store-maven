package frontend.edu.brown.optimizer.optimizations;

import org.apache.log4j.Logger;
import frontend.voltdb.plannodes.AbstractPlanNode;
import frontend.voltdb.plannodes.ReceivePlanNode;
import frontend.voltdb.utils.Pair;

import frontend.edu.brown.logging.LoggerUtil.LoggerBoolean;
import frontend.edu.brown.optimizer.PlanOptimizerState;

/**
 * 
 * @author mimosally
 * @author pavlo
 */
public class CombineOptimization extends AbstractOptimization {
    private static final Logger LOG = Logger.getLogger(CombineOptimization.class);
    private static final LoggerBoolean debug = new LoggerBoolean();

    public CombineOptimization(PlanOptimizerState state) {
        super(state);
    }

    @Override
    public Pair<Boolean, AbstractPlanNode> optimize(final AbstractPlanNode root) {
        
        if (root instanceof ReceivePlanNode) {
            // Mark as fast combine
            // System.err.println(PlanNodeUtil.debug(root));
        }
        
        return (Pair.of(true, root));
    }

}