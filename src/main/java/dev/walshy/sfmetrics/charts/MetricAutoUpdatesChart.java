package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics;

public class MetricAutoUpdatesChart extends Metrics.SimplePie {

    public MetricAutoUpdatesChart() {
        super("metrics_auto_updates", () -> {
            boolean enabled = SlimefunPlugin.getMetricsService().hasAutoUpdates();
            return enabled ? "enabled" : "disabled";
        });
    }
}
