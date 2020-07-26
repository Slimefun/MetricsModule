package dev.walshy.sfmetrics;

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
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics;

public class MetricsModule {

    public static final String VERSION = MetricsModule.class.getPackage().getImplementationVersion();
    public static final int PLUGIN_ID = 4574;

    private MetricsModule() {}

    public static void start() {
        Metrics metrics = new Metrics(SlimefunPlugin.instance(), PLUGIN_ID);

        if (SlimefunPlugin.getUpdater().getBranch().isOfficial()) {
            // We really do not need this data if it is an unofficially modified build...
            metrics.addCustomChart(new AutoUpdaterChart());
        }

        metrics.addCustomChart(new ResourcePackChart());
        metrics.addCustomChart(new SlimefunVersionChart());
        metrics.addCustomChart(new ServerLanguageChart());
        metrics.addCustomChart(new PlayerLanguageChart());
        metrics.addCustomChart(new ResearchesEnabledChart());
        metrics.addCustomChart(new GuideLayoutChart());
        metrics.addCustomChart(new AddonsChart());
        metrics.addCustomChart(new CommandChart());
        metrics.addCustomChart(new ServerSizeChart());
        metrics.addCustomChart(new CompatibilityModeChart());
        metrics.addCustomChart(new MetricsVersionChart());
        metrics.addCustomChart(new NewServersChart());

        SlimefunPlugin.instance().getLogger().info("Now running MetricsModule v" + VERSION);
    }
}
