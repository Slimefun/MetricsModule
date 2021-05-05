package dev.walshy.sfmetrics.charts;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bstats.charts.AdvancedPie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Server;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This {@link AdvancedPie} shows us what {@link SlimefunItem Items} have been disabled on the
 * {@link Server}.
 * <p>
 * This allows us to see what Items are very unpopular and may be considered for rework/removal.
 *
 * @author Walshy
 */
public class DisabledItemsChart extends AdvancedPie implements SlimefunMetricsChart {

    private static Map<String, Integer> disabledItems;

    public DisabledItemsChart() {
        super("disabled_items", () -> {
            if (disabledItems != null) {
                return disabledItems;
            } else {
                fetchItems();
                return Collections.emptyMap();
            }
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Disabled Items";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

    private static void fetchItems() {
        new Thread(() -> {
            disabledItems = new HashMap<>();
            for (SlimefunItem item : SlimefunPlugin.getRegistry().getAllSlimefunItems()) {
                if (item.getAddon().equals(SlimefunPlugin.instance()) && item.isDisabled()) {
                    disabledItems.put(item.getId(), 1);
                }
            }
        }, "Slimefun - disabled items fetcher").start();
    }
}
