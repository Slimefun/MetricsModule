package dev.walshy.sfmetrics;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import dev.walshy.sfmetrics.charts.AddonsChart;
import dev.walshy.sfmetrics.charts.AutoUpdaterChart;
import dev.walshy.sfmetrics.charts.CommandChart;
import dev.walshy.sfmetrics.charts.CompatibilityModeChart;
import dev.walshy.sfmetrics.charts.GuideLayoutChart;
import dev.walshy.sfmetrics.charts.PlayerLanguageChart;
import dev.walshy.sfmetrics.charts.ResearchesEnabledChart;
import dev.walshy.sfmetrics.charts.ResourcePackChart;
import dev.walshy.sfmetrics.charts.ServerLanguageChart;
import dev.walshy.sfmetrics.charts.ServerSizeChart;
import dev.walshy.sfmetrics.charts.SlimefunVersionChart;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;

@SuppressWarnings("unused")
public class MetricsModule {

    private static final String REPO_NAME = "MetricsModule";
    private static final String BUILDS_PAGE = "https://thebusybiscuit.github.io/builds/Slimefun/" + REPO_NAME;
    private static final String CURRENT_VERSION = MetricsModule.class.getPackage().getImplementationVersion();

    private MetricsModule() {}

    public static void start() {
        Metrics metrics = new Metrics(SlimefunPlugin.instance(), 4574);

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

        SlimefunPlugin.instance().getLogger().info("Now running SFMetrics v"
            + MetricsModule.class.getPackage().getImplementationVersion()
        );
    }

    public static boolean checkForUpdate() {
        if (CURRENT_VERSION.equals("UNOFFICIAL")) return false;

        int latest = getLatestVersion();
        if (latest > Integer.parseInt(CURRENT_VERSION)) {
            download(latest);
            return true;
        }
        return false;
    }

    public static int getLatestVersion() {
        if (CURRENT_VERSION.equals("UNOFFICIAL")) return -1;

        try {
            HttpResponse<JsonNode> response = Unirest.get(BUILDS_PAGE + "/builds.json")
                .header("User-Agent", "MetricsModule Auto-Updater")
                .asJson();
            if (response.getStatus() < 200 || response.getStatus() >= 300) return -1;

            JsonNode node = response.getBody();

            if (node == null) return -1;

            return node.getObject().getInt("last_successful");
        } catch (UnirestException e) {
            SlimefunPlugin.instance().getLogger().log(Level.SEVERE, "Failed to fetch latest builds for SFMetrics", e);
            return -1;
        }
    }

    public static void download(int version) {
        File outputFile = new File(SlimefunPlugin.instance().getDataFolder(), "MetricsModule.jar");

        try {
            HttpResponse<InputStream> response = Unirest.get(BUILDS_PAGE + "/master/" + REPO_NAME + '-' + version
                + ".jar").asBinary();

            if (response.getStatus() >= 200 && response.getStatus() < 300) {
                Files.copy(response.getBody(), outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (UnirestException e) {
            SlimefunPlugin.instance().getLogger().log(Level.WARNING, "Failed to fetch the latest jar file from the" +
                " builds page", e);
        } catch (IOException e) {
            SlimefunPlugin.instance().getLogger().log(Level.WARNING, "Failed to download and replace metrics module",
                e);
        }
    }
}
