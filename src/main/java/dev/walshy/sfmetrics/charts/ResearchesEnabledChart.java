package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics.SimplePie;

public class ResearchesEnabledChart extends SimplePie {

    public ResearchesEnabledChart() {
        super("servers_with_researches_enabled", () -> {
            boolean enabled = SlimefunPlugin.getRegistry().isFreeCreativeResearchingEnabled();
            return enabled ? "enabled" : "disabled";
        });
    }

}
