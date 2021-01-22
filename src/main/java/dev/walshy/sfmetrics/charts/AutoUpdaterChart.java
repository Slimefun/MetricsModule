package dev.walshy.sfmetrics.charts;

import javax.annotation.Nonnull;

import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;

import dev.walshy.sfmetrics.VersionDependentChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
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
public class AutoUpdaterChart extends SimplePie implements VersionDependentChart {

    public AutoUpdaterChart() {
        super("auto_updates", () -> {
            boolean enabled = SlimefunPlugin.getUpdater().isEnabled();
            return enabled ? "enabled" : "disabled";
        });
    }

    @Override
    public boolean isCompatible(@Nonnull SlimefunBranch branch, int build) {
        // Auto updates are only meaningful to us for official builds
        return branch.isOfficial();
    }

    @Nonnull
    @Override
    public String getName() {
        return "Auto Updates";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
