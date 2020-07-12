package dev.walshy.sfmetrics.charts;

import dev.walshy.sfmetrics.MetricsModule;
import org.bstats.bukkit.Metrics;

public class MetricsVersionChart extends Metrics.SimplePie {

    public MetricsVersionChart() {
        super("metrics_version", () -> MetricsModule.VERSION);
    }
}
