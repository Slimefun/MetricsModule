package dev.walshy.sfmetrics.charts;

import java.util.HashMap;
import java.util.Map;

import org.bstats.bukkit.Metrics;
import org.bstats.bukkit.Metrics.DrilldownPie;
import org.bukkit.Server;

import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link DrilldownPie} allows us to see what version of Slimefun is installed on
 * {@link Server Servers}. It is seperated by their {@link SlimefunBranch Branch}, so we
 * can also see what branches are preferred.
 * 
 * @author TheBusyBiscuit
 *
 */
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
