package dev.walshy.sfmetrics.charts;

import javax.annotation.Nonnull;

import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Bukkit;

import dev.walshy.sfmetrics.SlimefunMetricsChart;

public class CSCoreLibChart extends SimplePie implements SlimefunMetricsChart {

    public CSCoreLibChart() {
        super("cs-corelib_installed", () -> {
            boolean isCSCoreLibInstalled = Bukkit.getPluginManager().isPluginEnabled("CS-CoreLib");
            return isCSCoreLibInstalled ? "Yes" : "No";
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Is CS-CoreLib installed?";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
