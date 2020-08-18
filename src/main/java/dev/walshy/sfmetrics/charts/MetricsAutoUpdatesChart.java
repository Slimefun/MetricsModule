package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.MetricsModule;
import dev.walshy.sfmetrics.VersionDependentChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} shows us whether a {@link Server} has enabled or disabled
 * automatic updates for our {@link MetricsModule}.
 * 
 * @author Walshy
 *
 */
public class MetricsAutoUpdatesChart extends SimplePie implements VersionDependentChart {

    public MetricsAutoUpdatesChart() {
        super("metrics_auto_updates", () -> {
            boolean enabled = SlimefunPlugin.getMetricsService().hasAutoUpdates();
            return enabled ? "enabled" : "disabled";
        });
    }

    @Override
    public boolean isCompatible(SlimefunBranch branch, int build) {
        if (branch == SlimefunBranch.DEVELOPMENT) {
            return build >= 600;
        }
        else if (branch == SlimefunBranch.STABLE) {
            return build >= 15;
        }
        else {
            return false;
        }
    }

    @Override
    public String getName() {
        return "Metrics Auto Updates";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }
}
