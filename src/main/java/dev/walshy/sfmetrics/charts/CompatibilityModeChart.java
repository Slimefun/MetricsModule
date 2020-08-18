package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} shows us how many {@link Server Servers} have enabled or disabled
 * backwards-compatibility.
 * 
 * @author TheBusyBiscuit
 *
 */
public class CompatibilityModeChart extends SimplePie implements SlimefunMetricsChart {

    public CompatibilityModeChart() {
        super("compatibility_mode", () -> {
            boolean enabled = SlimefunPlugin.getRegistry().isBackwardsCompatible();
            return enabled ? "enabled" : "disabled";
        });
    }

    @Override
    public String getName() {
        return "Compatibility Mode";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
