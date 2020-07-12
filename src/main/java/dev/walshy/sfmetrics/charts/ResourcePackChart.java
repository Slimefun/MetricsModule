package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics.SimplePie;

public class ResourcePackChart extends SimplePie {

    public ResourcePackChart() {
        super("resourcepack", () -> {
            String version = SlimefunPlugin.getItemTextureService().getVersion();

            if (version != null && version.startsWith("v")) {
                return version + " (Official)";
            } else if (SlimefunPlugin.getItemTextureService().isActive()) {
                return "Custom / Modified";
            } else {
                return "None";
            }
        });
    }

}
