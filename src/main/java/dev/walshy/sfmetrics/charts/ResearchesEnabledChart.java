package dev.walshy.sfmetrics.charts;

import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import javax.annotation.Nonnull;

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
            boolean enabled = Slimefun.getRegistry().isFreeCreativeResearchingEnabled();
            return enabled ? "enabled" : "disabled";
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Researches enabled";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
