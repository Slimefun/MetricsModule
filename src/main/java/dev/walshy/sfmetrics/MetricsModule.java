package dev.walshy.sfmetrics;

import java.util.function.Supplier;
import java.util.logging.Level;

import org.bstats.bukkit.Metrics;
import org.bstats.bukkit.Metrics.CustomChart;

import dev.walshy.sfmetrics.charts.AddonsChart;
import dev.walshy.sfmetrics.charts.AutoUpdaterChart;
import dev.walshy.sfmetrics.charts.CommandChart;
import dev.walshy.sfmetrics.charts.CompatibilityModeChart;
import dev.walshy.sfmetrics.charts.GuideLayoutChart;
import dev.walshy.sfmetrics.charts.MetricsVersionChart;
import dev.walshy.sfmetrics.charts.NewServersChart;
import dev.walshy.sfmetrics.charts.PlayerLanguageChart;
import dev.walshy.sfmetrics.charts.ResearchesEnabledChart;
import dev.walshy.sfmetrics.charts.ResourcePackChart;
import dev.walshy.sfmetrics.charts.ServerLanguageChart;
import dev.walshy.sfmetrics.charts.ServerSizeChart;
import dev.walshy.sfmetrics.charts.SlimefunVersionChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

public class MetricsModule {

    public static final String VERSION = MetricsModule.class.getPackage().getImplementationVersion();
    public static final int PLUGIN_ID = 4574;

    private MetricsModule() {}

    public static void start() {
        Metrics metrics = new Metrics(SlimefunPlugin.instance(), PLUGIN_ID);

        SlimefunPlugin.instance().getLogger().info("Now running MetricsModule build #" + VERSION);

        SlimefunBranch branch = SlimefunPlugin.getUpdater().getBranch();
        int slimefunVersion = SlimefunPlugin.getUpdater().getBuildNumber();

        addChart(metrics, branch, slimefunVersion, AutoUpdaterChart::new);
        addChart(metrics, branch, slimefunVersion, ResourcePackChart::new);
        addChart(metrics, branch, slimefunVersion, SlimefunVersionChart::new);
        addChart(metrics, branch, slimefunVersion, ServerLanguageChart::new);
        addChart(metrics, branch, slimefunVersion, PlayerLanguageChart::new);
        addChart(metrics, branch, slimefunVersion, ResearchesEnabledChart::new);
        addChart(metrics, branch, slimefunVersion, GuideLayoutChart::new);
        addChart(metrics, branch, slimefunVersion, AddonsChart::new);
        addChart(metrics, branch, slimefunVersion, CommandChart::new);
        addChart(metrics, branch, slimefunVersion, ServerSizeChart::new);
        addChart(metrics, branch, slimefunVersion, CompatibilityModeChart::new);
        addChart(metrics, branch, slimefunVersion, MetricsVersionChart::new);
        addChart(metrics, branch, slimefunVersion, NewServersChart::new);
    }

    private static void addChart(Metrics metrics, SlimefunBranch branch, int build, Supplier<CustomChart> constructor) {
        try {
            CustomChart chart = constructor.get();

            if (chart instanceof VersionDependentChart && !((VersionDependentChart) chart).isCompatible(branch, build)) {
                // Not compatible with this Slimefun version
                return;
            }

            metrics.addCustomChart(chart);
        }
        catch (Exception | LinkageError x) {
            SlimefunPlugin.instance().getLogger().log(Level.WARNING, x, () -> "Failed to load a bStats chart for Metrics #" + VERSION);
        }
    }
}
