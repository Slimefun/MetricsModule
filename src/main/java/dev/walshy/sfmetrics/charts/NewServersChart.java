package dev.walshy.sfmetrics.charts;

import javax.annotation.Nonnull;

import org.bstats.charts.SingleLineChart;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import dev.walshy.sfmetrics.VersionDependentChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

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
            boolean newServer = Slimefun.isNewlyInstalled();
            return newServer ? 1 : 0;
        });
    }

    @Override
    public boolean isCompatible(@Nonnull SlimefunBranch branch, int build) {
        if (branch == SlimefunBranch.DEVELOPMENT) {
            return build >= 600;
        } else if (branch == SlimefunBranch.STABLE) {
            return build >= 15;
        } else {
            return false;
        }
    }

    @Nonnull
    @Override
    public String getName() {
        return "New Servers";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
