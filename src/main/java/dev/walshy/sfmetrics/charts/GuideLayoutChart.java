package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics.SimplePie;

public class GuideLayoutChart extends SimplePie {

    public GuideLayoutChart() {
        super("guide_layout", () -> {
            boolean book = SlimefunPlugin.getCfg().getBoolean("guide.default-view-book");

            return book ? "Book" : "Chest GUI";
        });
    }

}
