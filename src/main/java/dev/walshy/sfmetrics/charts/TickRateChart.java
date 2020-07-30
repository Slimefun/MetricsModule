package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} shows us the configured tick rate.
 * 
 * @author TheBusyBiscuit
 *
 */
public class TickRateChart extends SimplePie {

    public TickRateChart() {
        super("tick_rate", () -> String.valueOf(SlimefunPlugin.getTickerTask().getTickRate()));
    }

}
