package frontend.edu.brown.optimizer.optimizations;

import frontend.voltdb.plannodes.AbstractPlanNode;
import frontend.voltdb.utils.Pair;

import frontend.edu.brown.optimizer.PlanOptimizerState;

public abstract class AbstractOptimization {

    protected final PlanOptimizerState state;

    public AbstractOptimization(PlanOptimizerState state) {
        this.state = state;
    }

    /**
     * Perform the optimization on the given PlanNode tree Returns a pair
     * containing the new root of the tree a boolean flag that signals whether
     * the tree was modified or not
     * 
     * @param rootNode
     * @return
     */
    public abstract Pair<Boolean, AbstractPlanNode> optimize(final AbstractPlanNode rootNode);

}
