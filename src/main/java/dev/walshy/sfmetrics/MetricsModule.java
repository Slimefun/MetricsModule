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
import dev.walshy.sfmetrics.charts.MetricsAutoUpdatesChart;
import dev.walshy.sfmetrics.charts.MetricsVersionChart;
import dev.walshy.sfmetrics.charts.NewServersChart;
import dev.walshy.sfmetrics.charts.PlayerLanguageChart;
import dev.walshy.sfmetrics.charts.ResearchesEnabledChart;
import dev.walshy.sfmetrics.charts.ResourcePackChart;
import dev.walshy.sfmetrics.charts.ServerLanguageChart;
import dev.walshy.sfmetrics.charts.ServerSizeChart;
import dev.walshy.sfmetrics.charts.SlimefunVersionChart;
import dev.walshy.sfmetrics.charts.TickRateChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

public class MetricsModule {

    public static final String VERSION = MetricsModule.class.getPackage().getImplementationVersion();
    public static final int PLUGIN_ID = 4574;

    private static SlimefunBranch branch = SlimefunBranch.UNKNOWN;
    private static int slimefunVersion = -1;
    private static int charts = 0;

    private MetricsModule() {}

    public static void start() {
        Metrics metrics = new Metrics(SlimefunPlugin.instance(), PLUGIN_ID);
        branch = SlimefunPlugin.getUpdater().getBranch();
        slimefunVersion = SlimefunPlugin.getUpdater().getBuildNumber();

        addChart(metrics, AutoUpdaterChart::new);
        addChart(metrics, ResourcePackChart::new);
        addChart(metrics, SlimefunVersionChart::new);
        addChart(metrics, ServerLanguageChart::new);
        addChart(metrics, PlayerLanguageChart::new);
        addChart(metrics, ResearchesEnabledChart::new);
        addChart(metrics, GuideLayoutChart::new);
        addChart(metrics, AddonsChart::new);
        addChart(metrics, CommandChart::new);
        addChart(metrics, ServerSizeChart::new);
        addChart(metrics, CompatibilityModeChart::new);
        addChart(metrics, MetricsVersionChart::new);
        addChart(metrics, NewServersChart::new);
        addChart(metrics, MetricsAutoUpdatesChart::new);
        addChart(metrics, TickRateChart::new);

        SlimefunPlugin.instance().getLogger().log(Level.INFO, "Now running MetricsModule build #{0}", VERSION);
        SlimefunPlugin.instance().getLogger().log(Level.INFO, "with a total of {0} chart(s)!", charts);
    }

    private static void addChart(Metrics metrics, Supplier<CustomChart> constructor) {
        try {
            CustomChart chart = constructor.get();

            if (chart instanceof VersionDependentChart && !((VersionDependentChart) chart).isCompatible(branch, slimefunVersion)) {
                // Not compatible with this Slimefun version
                return;
            }

            metrics.addCustomChart(chart);
            charts++;
        }
        catch (Exception | LinkageError x) {
            SlimefunPlugin.instance().getLogger().log(Level.WARNING, x, () -> "Failed to load a bStats chart for Metrics #" + VERSION);
        }
    }
}
