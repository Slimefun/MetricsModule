package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics.AdvancedPie;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class AddonsChart extends AdvancedPie {

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

}
