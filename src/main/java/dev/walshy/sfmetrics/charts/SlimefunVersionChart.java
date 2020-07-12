package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics;

import java.util.HashMap;
import java.util.Map;

public class SlimefunVersionChart extends Metrics.DrilldownPie {

    public SlimefunVersionChart() {
        super("slimefun_version", () -> {
            Map<String, Map<String, Integer>> outerMap = new HashMap<>();
            Map<String, Integer> innerMap = new HashMap<>();

            innerMap.put(SlimefunPlugin.getVersion(), 1);
            outerMap.put(SlimefunPlugin.getUpdater().getBranch().getName(), innerMap);

            return outerMap;
        });
    }
}
