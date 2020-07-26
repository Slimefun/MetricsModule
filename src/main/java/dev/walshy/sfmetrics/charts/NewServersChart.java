package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SingleLineChart;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This single line graph shows the amount of {@link Server Servers} that installed
 * Slimefun for the very first time at that moment in time.
 * 
 * This allows us to better analyse the growth of this {@link Plugin} on a day-to-day basis.
 * 
 * @author TheBusyBiscuit
 *
 */
public class NewServersChart extends SingleLineChart {

    public NewServersChart() {
        super("auto_updates", () -> {
            boolean newServer = SlimefunPlugin.isNewlyInstalled();
            return newServer ? 1 : 0;
        });
    }

}
