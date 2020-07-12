package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics.SimplePie;

public class AutoUpdaterChart extends SimplePie {

    public AutoUpdaterChart() {
        super("auto_updates", () -> {
            boolean enabled = SlimefunPlugin.getUpdater().isEnabled();
            return enabled ? "enabled" : "disabled";
        });
    }

}
