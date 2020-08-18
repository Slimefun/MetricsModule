package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} allows us to see how many {@link Server Servers} have enabled or
 * disabled {@link Research Researches}.
 * 
 * @author TheBusyBiscuit
 *
 */
public class ResearchesEnabledChart extends SimplePie implements SlimefunMetricsChart {

    public ResearchesEnabledChart() {
        super("servers_with_researches_enabled", () -> {
            boolean enabled = SlimefunPlugin.getRegistry().isFreeCreativeResearchingEnabled();
            return enabled ? "enabled" : "disabled";
        });
    }

    @Override
    public String getName() {
        return "Researches enabled";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
