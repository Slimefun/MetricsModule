package dev.walshy.sfmetrics.charts;

import java.util.HashMap;
import java.util.Map;

import org.bstats.charts.AdvancedPie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

import javax.annotation.Nonnull;

/**
 * This {@link AdvancedPie} shows us what {@link SlimefunAddon Addons} are installed on the
 * {@link Server}.
 * 
 * This allows us to see what Addons are popular than others in one overview.
 * 
 * @author TheBusyBiscuit
 *
 */
public class AddonsChart extends AdvancedPie implements SlimefunMetricsChart {

    public AddonsChart() {
        super("installed_addons", () -> {
            Map<String, Integer> addons = new HashMap<>();

            for (Plugin plugin : SlimefunPlugin.getInstalledAddons()) {
                if (plugin.isEnabled()) {
                    addons.put(plugin.getName(), 1);
                }
            }

            return addons;
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Addons";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
