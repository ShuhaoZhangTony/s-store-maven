/* This file is part of VoltDB.
 * Copyright (C) 2008-2010 VoltDB L.L.C.
 *
 * VoltDB is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VoltDB is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VoltDB.  If not, see <http://www.gnu.org/licenses/>.
 */

package frontend.voltdb.plannodes;

import frontend.voltdb.catalog.Cluster;
import frontend.voltdb.catalog.Database;
import frontend.voltdb.catalog.Table;
import frontend.voltdb.compiler.DatabaseEstimates;
import frontend.voltdb.compiler.ScalarValueHints;
import frontend.voltdb.planner.PlanStatistics;
import frontend.voltdb.planner.PlannerContext;
import frontend.voltdb.planner.StatsField;
import frontend.voltdb.types.PlanNodeType;
import frontend.voltdb.catalog.Cluster;
import frontend.voltdb.catalog.Database;
import frontend.voltdb.catalog.Table;
import frontend.voltdb.planner.PlanStatistics;
import frontend.voltdb.planner.PlannerContext;
import frontend.voltdb.planner.StatsField;
import frontend.voltdb.types.PlanNodeType;
import frontend.voltdb.catalog.Cluster;
import frontend.voltdb.catalog.Database;
import frontend.voltdb.catalog.Table;
import frontend.voltdb.planner.PlanStatistics;
import frontend.voltdb.planner.PlannerContext;
import frontend.voltdb.planner.StatsField;
import frontend.voltdb.types.PlanNodeType;

/**
 *
 */
public class SeqScanPlanNode extends AbstractScanPlanNode {
    /**
     * @param id
     */
    public SeqScanPlanNode(PlannerContext context, Integer id) {
        super(context, id);
    }

    @Override
    public PlanNodeType getPlanNodeType() {
        return PlanNodeType.SEQSCAN;
    }

    @Override
    public boolean computeEstimatesRecursively(PlanStatistics stats, Cluster cluster, Database db, DatabaseEstimates estimates, ScalarValueHints[] paramHints) {
        Table target = db.getTables().getIgnoreCase(m_targetTableName);
        assert(target != null);
        DatabaseEstimates.TableEstimates tableEstimates = estimates.getEstimatesForTable(target.getTypeName());
        stats.incrementStatistic(0, StatsField.TUPLES_READ, tableEstimates.maxTuples);
        m_estimatedOutputTupleCount = tableEstimates.maxTuples;
        return true;
    }

}
