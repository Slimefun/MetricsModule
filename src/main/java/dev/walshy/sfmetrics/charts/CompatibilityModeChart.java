package dev.walshy.sfmetrics.charts;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;

import javax.annotation.Nonnull;

/**
 * This {@link SimplePie} shows us how many {@link Server Servers} have enabled or disabled
 * backwards-compatibility.
 *
 * @author TheBusyBiscuit
 */
public class CompatibilityModeChart extends SimplePie implements SlimefunMetricsChart {

    public CompatibilityModeChart() {
        super("compatibility_mode", () -> {
            boolean enabled = Slimefun.getRegistry().isBackwardsCompatible();
            return enabled ? "enabled" : "disabled";
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Compatibility Mode";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
