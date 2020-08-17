package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.MetricsModule;
import dev.walshy.sfmetrics.SlimefunMetricsChart;

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

    @Override
    public String getName() {
        return "Metrics Version";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }
}
