package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SingleLineChart;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import dev.walshy.sfmetrics.VersionDependentChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This single line graph shows the amount of {@link Server Servers} that installed
 * Slimefun for the very first time.
 * More precisely: A {@link Server} will be included if the current session is the session
 * in which Slimefun was first installed.
 * It will be reset once the {@link Server} has stopped or restarted.
 * Subsequent sessions will then no longer be counted.
 * 
 * This allows us to better analyse the growth of this {@link Plugin} on a day-to-day basis.
 * 
 * @author TheBusyBiscuit
 *
 */
public class NewServersChart extends SingleLineChart implements VersionDependentChart {

    public NewServersChart() {
        super("new_servers", () -> {
            boolean newServer = SlimefunPlugin.isNewlyInstalled();
            return newServer ? 1 : 0;
        });
    }

    @Override
    public boolean isCompatible(SlimefunBranch branch, int build) {
        if (branch == SlimefunBranch.DEVELOPMENT) {
            return build >= 600;
        }
        else if (branch == SlimefunBranch.STABLE) {
            return build >= 15;
        }
        else {
            return false;
        }
    }

}
