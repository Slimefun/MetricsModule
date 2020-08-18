package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.core.services.localization.Language;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} allows us to see what {@link Server Servers} have configured as their
 * default {@link Language}.
 * 
 * @author TheBusyBiscuit
 *
 */
public class ServerLanguageChart extends SimplePie implements SlimefunMetricsChart {

    public ServerLanguageChart() {
        super("language", () -> {
            Language language = SlimefunPlugin.getLocalization().getDefaultLanguage();
            boolean supported = SlimefunPlugin.getLocalization().isLanguageLoaded(language.getId());
            return supported ? language.getId() : "Unsupported Language";
        });
    }

    @Override
    public String getName() {
        return "Server Language";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
