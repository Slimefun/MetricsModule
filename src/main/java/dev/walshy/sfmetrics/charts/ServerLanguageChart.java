package dev.walshy.sfmetrics.charts;

import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.core.services.localization.Language;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import javax.annotation.Nonnull;

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
            Language language = Slimefun.getLocalization().getDefaultLanguage();
            boolean supported = Slimefun.getLocalization().isLanguageLoaded(language.getId());
            return supported ? language.getId() : "Unsupported Language";
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Server Language";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
