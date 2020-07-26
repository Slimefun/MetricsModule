package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;

import dev.walshy.sfmetrics.MetricsModule;

/**
 * This {@link SimplePie} shows us the currently installed version of this {@link MetricsModule}.
 * 
 * @author Walshy
 *
 */
public class MetricsVersionChart extends SimplePie {

    public MetricsVersionChart() {
        super("metrics_version", () -> MetricsModule.VERSION);
    }
}
