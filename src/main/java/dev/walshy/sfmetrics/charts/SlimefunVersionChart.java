package dev.walshy.sfmetrics.charts;

import java.util.HashMap;
import java.util.Map;

import org.bstats.charts.DrilldownPie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

import javax.annotation.Nonnull;

/**
 * This {@link DrilldownPie} allows us to see what version of Slimefun is installed on
 * {@link Server Servers}. It is seperated by their {@link SlimefunBranch Branch}, so we
 * can also see what branches are preferred.
 * 
 * @author TheBusyBiscuit
 *
 */
public class SlimefunVersionChart extends DrilldownPie implements SlimefunMetricsChart {

    public SlimefunVersionChart() {
        super("slimefun_version", () -> {
            Map<String, Map<String, Integer>> outerMap = new HashMap<>();
            Map<String, Integer> innerMap = new HashMap<>();

            innerMap.put(SlimefunPlugin.getVersion(), 1);
            outerMap.put(SlimefunPlugin.getUpdater().getBranch().getName(), innerMap);

            return outerMap;
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Slimefun Version";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }
}
