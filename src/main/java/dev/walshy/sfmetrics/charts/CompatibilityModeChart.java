package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics.SimplePie;

public class CompatibilityModeChart extends SimplePie {

    public CompatibilityModeChart() {
        super("compatibility_mode", () -> {
            boolean enabled = SlimefunPlugin.getRegistry().isBackwardsCompatible();
            return enabled ? "enabled" : "disabled";
        });
    }

}
