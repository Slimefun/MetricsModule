package dev.walshy.sfmetrics;

import java.util.function.Supplier;
import java.util.logging.Level;

import javax.annotation.ParametersAreNonnullByDefault;

import dev.walshy.sfmetrics.charts.DisabledItemsChart;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.CustomChart;

import dev.walshy.sfmetrics.charts.AddonsChart;
import dev.walshy.sfmetrics.charts.AutoUpdaterChart;
import dev.walshy.sfmetrics.charts.CSCoreLibChart;
import dev.walshy.sfmetrics.charts.CommandChart;
import dev.walshy.sfmetrics.charts.CompatibilityModeChart;
import dev.walshy.sfmetrics.charts.ErrorReportsChart;
import dev.walshy.sfmetrics.charts.IntegrationsChart;
import dev.walshy.sfmetrics.charts.MetricsAutoUpdatesChart;
import dev.walshy.sfmetrics.charts.MetricsVersionChart;
import dev.walshy.sfmetrics.charts.NewServersChart;
import dev.walshy.sfmetrics.charts.OnlinePlayersChart;
import dev.walshy.sfmetrics.charts.PlayerLanguageChart;
import dev.walshy.sfmetrics.charts.ResearchesEnabledChart;
import dev.walshy.sfmetrics.charts.ResourcePackChart;
import dev.walshy.sfmetrics.charts.ServerLanguageChart;
import dev.walshy.sfmetrics.charts.SlimefunVersionChart;
import dev.walshy.sfmetrics.charts.TickRateChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

public class MetricsModule {

    public static final String VERSION = MetricsModule.class.getPackage().getImplementationVersion();
    public static final int PLUGIN_ID = 4574;

    private static boolean metricsAutoUpdates;
    private static SlimefunBranch branch = SlimefunBranch.UNKNOWN;
    private static int slimefunVersion = -1;

    private static int enabledCharts = 0;
    private static int totalCharts = 0;

    private MetricsModule() {}

    public static void start() {
        Metrics metrics = new Metrics(SlimefunPlugin.instance(), PLUGIN_ID);
        branch = SlimefunPlugin.getUpdater().getBranch();
        slimefunVersion = SlimefunPlugin.getUpdater().getBuildNumber();
        metricsAutoUpdates = SlimefunPlugin.getMetricsService().hasAutoUpdates();

        addChart(metrics, AutoUpdaterChart::new);
        addChart(metrics, ResourcePackChart::new);
        addChart(metrics, SlimefunVersionChart::new);
        addChart(metrics, ServerLanguageChart::new);
        addChart(metrics, PlayerLanguageChart::new);
        addChart(metrics, ResearchesEnabledChart::new);
        addChart(metrics, AddonsChart::new);
        addChart(metrics, CommandChart::new);
        addChart(metrics, OnlinePlayersChart::new);
        addChart(metrics, CompatibilityModeChart::new);
        addChart(metrics, MetricsVersionChart::new);
        addChart(metrics, NewServersChart::new);
        addChart(metrics, MetricsAutoUpdatesChart::new);
        addChart(metrics, TickRateChart::new);
        addChart(metrics, ErrorReportsChart::new);
        addChart(metrics, IntegrationsChart::new);
        addChart(metrics, CSCoreLibChart::new);
        addChart(metrics, DisabledItemsChart::new);

        SlimefunPlugin.instance().getLogger().log(Level.INFO, "Now running MetricsModule build #{0}", VERSION);
        SlimefunPlugin.instance().getLogger().log(Level.INFO, "with a total of {0}/{1} chart(s)!", new Object[] { enabledCharts, totalCharts });
    }

    @ParametersAreNonnullByDefault
    private static <T extends CustomChart & SlimefunMetricsChart> void addChart(Metrics metrics, Supplier<T> constructor) {
        T chart = null;
        totalCharts++;

        try {
            chart = constructor.get();

            if (chart instanceof VersionDependentChart && !((VersionDependentChart) chart).isCompatible(branch, slimefunVersion)) {
                // Not compatible with this Slimefun version
                return;
            }

            // Test for any runtime exceptions
            chart.getDataSample();

            metrics.addCustomChart(chart);
            enabledCharts++;
        } catch (Exception | LinkageError x) {
            warn(chart == null ? "Unknown" : chart.getName(), x);
        }
    }

    @ParametersAreNonnullByDefault
    private static void warn(String chartName, Throwable x) {
        if (!metricsAutoUpdates) {
            SlimefunPlugin.instance().getLogger().log(Level.WARNING, "Turn on Auto-Updates for Slimefun-Metrics to avoid this issue!");
        }

        SlimefunPlugin.instance().getLogger().log(Level.WARNING, x, () -> "Failed to load bStats Chart \"" + chartName + "\" for Metrics #" + VERSION);
    }
}
