package benchmarks.org.voltdb.benchmark.tpcc;

import frontend.voltdb.catalog.Database;

import frontend.edu.brown.statistics.AbstractTableStatisticsGenerator;
import frontend.edu.brown.utils.ProjectType;

/**
 * TPCCTableStatisticsGenerator
 * @author pavlo
 */
public class TPCCTableStatisticsGenerator extends AbstractTableStatisticsGenerator {

    public TPCCTableStatisticsGenerator(Database catalog_db, double scale_factor) {
        super(catalog_db, ProjectType.TPCC, scale_factor);
    }
    
    @Override
    public void createProfiles() {
        // TODO Auto-generated method stub
    }

}
