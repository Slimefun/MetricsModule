package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} shows us how many {@link Server Servers} have enabled or disabled
 * automatic updates.
 * 
 * This allows us to understand how many {@link Server Servers} opted out of automatic updates.
 * 
 * @author TheBusyBiscuit
 *
 */
public class AutoUpdaterChart extends SimplePie {

    public AutoUpdaterChart() {
        super("auto_updates", () -> {
            boolean enabled = SlimefunPlugin.getUpdater().isEnabled();
            return enabled ? "enabled" : "disabled";
        });
    }

}
