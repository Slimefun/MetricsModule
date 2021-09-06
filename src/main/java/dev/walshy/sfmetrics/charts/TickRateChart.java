package dev.walshy.sfmetrics.charts;

import java.util.HashMap;
import java.util.Map;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bstats.charts.DrilldownPie;
import org.bstats.json.JsonObjectBuilder;

import javax.annotation.Nonnull;

/**
 * This {@link DrilldownPie} shows us the configured tick rate.
 * It can show both, cargo and normal tick rates.
 * 
 * @author TheBusyBiscuit
 *
 */
public class TickRateChart extends DrilldownPie implements SlimefunMetricsChart {

    public TickRateChart() {
        super("tick_rate", () -> {
            Map<String, Map<String, Integer>> map = new HashMap<>();
            int tickRate = Slimefun.getTickerTask().getTickRate();
            int armorTickRate = Slimefun.getCfg().getInt("options.armor-update-interval");
            int cargoDelay = Slimefun.getCfg().getInt("networks.cargo-ticker-delay");

            // For normal blocks the tick-rate will be taken literal
            Map<String, Integer> normal = new HashMap<>();
            normal.put(String.valueOf(tickRate), 1);

            // For cargo networks we have an additional "delay" variable which
            // will make the ticker skip ticks, so the tick rate will be equal to
            // x + x * n where n is the delay, defaulting at 0.
            Map<String, Integer> cargo = new HashMap<>();
            cargo.put(String.valueOf(tickRate + tickRate * cargoDelay), 1);

            // The armor tick rate
            Map<String, Integer> armor = new HashMap<>();
            armor.put(String.valueOf(armorTickRate), 1);

            map.put("Standard", normal);
            map.put("Slimefun Armor / Radiation", armor);
            map.put("Cargo networks", cargo);

            return map;
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Tick Rates";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
