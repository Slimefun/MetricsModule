package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} allows us to see what Slimefun Resource pack version is installed on
 * {@link Server Servers} or whether they set up their resource packs.
 * 
 * @author TheBusyBiscuit
 *
 */
public class ResourcePackChart extends SimplePie implements SlimefunMetricsChart {

    public ResourcePackChart() {
        super("resourcepack", () -> {
            String version = SlimefunPlugin.getItemTextureService().getVersion();

            if (version != null && version.startsWith("v")) {
                return version + " (Official)";
            }
            else if (SlimefunPlugin.getItemTextureService().isActive()) {
                return "Custom / Modified";
            }
            else {
                return "None";
            }
        });
    }

    @Override
    public String getName() {
        return "Resource Packs";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
