package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Server;

import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link SimplePie} allows us to see what {@link Server Servers} tend to set as
 * their default {@link SlimefunGuideLayout}.
 * 
 * @author TheBusyBiscuit
 *
 */
public class GuideLayoutChart extends SimplePie {

    public GuideLayoutChart() {
        super("guide_layout", () -> {
            boolean book = SlimefunPlugin.getCfg().getBoolean("guide.default-view-book");

            return book ? "Book" : "Chest GUI";
        });
    }

}
