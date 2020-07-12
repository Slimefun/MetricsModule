package dev.walshy.sfmetrics.charts;

import dev.walshy.sfmetrics.MetricsModule;
import org.bstats.bukkit.Metrics;

import java.util.HashMap;
import java.util.Map;

public class MetricVersionChart extends Metrics.AdvancedPie {

    public MetricVersionChart() {
        super("slimefun_metric_version", () -> {
            Map<String, Integer> version = new HashMap<>();

            version.put(MetricsModule.VERSION, 1);
            return version;
        });
    }
}
