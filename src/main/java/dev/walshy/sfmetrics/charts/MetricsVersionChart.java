package dev.walshy.sfmetrics.charts;

import dev.walshy.sfmetrics.MetricsModule;
import dev.walshy.sfmetrics.SlimefunMetricsChart;
import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;

import javax.annotation.Nonnull;

/**
 * This {@link SimplePie} shows us the currently installed version of this {@link MetricsModule}.
 * 
 * @author Walshy
 *
 */
public class MetricsVersionChart extends SimplePie implements SlimefunMetricsChart {

    public MetricsVersionChart() {
        super("metrics_version", () -> MetricsModule.VERSION);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Metrics Version";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }
}
