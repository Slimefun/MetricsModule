package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} allows us to see what {@link Server Servers} tend to set as
 * their default {@link SlimefunGuideLayout}.
 * 
 * @author TheBusyBiscuit
 *
 */
public class GuideLayoutChart extends SimplePie implements SlimefunMetricsChart {

    public GuideLayoutChart() {
        super("guide_layout", () -> {
            boolean book = SlimefunPlugin.getCfg().getBoolean("guide.default-view-book");

            return book ? "Book" : "Chest GUI";
        });
    }

    @Override
    public String getName() {
        return "Slimefun Guide Layout";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
