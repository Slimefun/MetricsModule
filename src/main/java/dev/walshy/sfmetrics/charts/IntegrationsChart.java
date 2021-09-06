package dev.walshy.sfmetrics.charts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bstats.charts.AdvancedPie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

/**
 * This {@link AdvancedPie} shows us which {@link Plugin Plugins} the current
 * Slimefun installation has integrated with.
 * 
 * @author TheBusyBiscuit
 *
 */
public class IntegrationsChart extends AdvancedPie implements SlimefunMetricsChart {

    public IntegrationsChart() {
        super("integrations", () -> {
            Slimefun slimefun = Slimefun.instance();
            Map<String, Integer> plugins = new HashMap<>();

            // Hard dependencies
            findDependencies(plugins, slimefun.getServer().getPluginManager(), slimefun.getDescription().getDepend());

            // Soft dependencies
            findDependencies(plugins, slimefun.getServer().getPluginManager(), slimefun.getDescription().getSoftDepend());

            return plugins;
        });
    }

    @ParametersAreNonnullByDefault
    private static void findDependencies(Map<String, Integer> plugins, PluginManager pm, List<String> dependencies) {
        for (String plugin : dependencies) {
            // No need to list CS-CoreLib here
            if (!plugin.equals("CS-CoreLib") && pm.isPluginEnabled(plugin)) {
                plugins.put(plugin, 1);
            }
        }
    }

    @Nonnull
    @Override
    public String getName() {
        return "Integrations";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
