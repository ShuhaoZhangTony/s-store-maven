package frontend.edu.brown.hstore.stats;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import frontend.voltdb.StatsSource;
import frontend.voltdb.SysProcSelector;
import frontend.voltdb.VoltTable;
import frontend.voltdb.VoltTable.ColumnInfo;
import frontend.voltdb.VoltType;

import frontend.edu.brown.hstore.AntiCacheManager;
import frontend.edu.brown.hstore.HStoreSite;
import frontend.edu.brown.logging.LoggerUtil;
import frontend.edu.brown.logging.LoggerUtil.LoggerBoolean;
import frontend.edu.brown.profilers.AntiCacheManagerProfiler;
import frontend.edu.brown.profilers.ProfileMeasurement;

public class AntiCacheManagerProfilerStats extends StatsSource {
    private static final Logger LOG = Logger.getLogger(AntiCacheManagerProfilerStats.class);
    private static final LoggerBoolean debug = new LoggerBoolean();
    static {
        LoggerUtil.attachObserver(LOG, debug);
    }

    private final HStoreSite hstore_site;
    private final AntiCacheManager anticache;

    public AntiCacheManagerProfilerStats(HStoreSite hstore_site) {
        super(SysProcSelector.ANTICACHE.name(), false);
        this.hstore_site = hstore_site;
        this.anticache = hstore_site.getAntiCacheManager();
    }
    
    @Override
    protected Iterator<Object> getStatsRowKeyIterator(boolean interval) {
        final Iterator<Integer> it = hstore_site.getLocalPartitionIds().iterator();
        return new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }
            @Override
            public Object next() {
                return it.next();
            }
            @Override
            public void remove() {
                it.remove();
            }
        };
    }

    @Override
    protected void populateColumnSchema(ArrayList<ColumnInfo> columns) {
        super.populateColumnSchema(columns);
        columns.add(new VoltTable.ColumnInfo("PARTITION", VoltType.INTEGER));
        
        // Make a dummy profiler just so that we can get the fields from it
        AntiCacheManagerProfiler profiler = new AntiCacheManagerProfiler();
        assert(profiler != null);
        
        columns.add(new VoltTable.ColumnInfo("RESTARTED_TXNS", VoltType.INTEGER));
        for (ProfileMeasurement pm : profiler.getProfileMeasurements()) {
            String name = pm.getName().toUpperCase();
            columns.add(new VoltTable.ColumnInfo(name, VoltType.BIGINT));
            columns.add(new VoltTable.ColumnInfo(name+"_CNT", VoltType.BIGINT));
        } // FOR
    }

    @Override
    protected synchronized void updateStatsRow(Object rowKey, Object[] rowValues) {
        int partition = (Integer)rowKey;
        AntiCacheManager.Debug dbg = this.anticache.getDebugContext();
        AntiCacheManagerProfiler profiler = dbg.getProfiler(partition);
        
        int offset = this.columnNameToIndex.get("PARTITION");
        rowValues[offset++] = partition;
        rowValues[offset++] = profiler.restarted_txns;
        
        for (ProfileMeasurement pm : profiler.getProfileMeasurements()) {
            rowValues[offset++] = pm.getTotalThinkTime();
            rowValues[offset++] = pm.getInvocations();
        } // FOR

        super.updateStatsRow(rowKey, rowValues);
    }
}
