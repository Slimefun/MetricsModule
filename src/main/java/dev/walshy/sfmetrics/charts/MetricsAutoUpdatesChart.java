package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics;

public class MetricsAutoUpdatesChart extends Metrics.SimplePie {

    public MetricsAutoUpdatesChart() {
        super("metrics_auto_updates", () -> {
            boolean enabled = SlimefunPlugin.getMetricsService().hasAutoUpdates();
            return enabled ? "enabled" : "disabled";
        });
    }
}
