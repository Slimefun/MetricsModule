package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.Server;

import com.google.gson.JsonObject;

import dev.walshy.sfmetrics.SlimefunMetricsChart;

/**
 * This {@link SimplePie} allows us to see how big a {@link Server} is (player-wise).
 * 
 * @author TheBusyBiscuit
 *
 */
public class OnlinePlayersChart extends SimplePie implements SlimefunMetricsChart {

    public OnlinePlayersChart() {
        super("online_players", () -> {
            int players = Bukkit.getOnlinePlayers().size();

            if (players <= 5) {
                return "0-5";
            }
            else if (players <= 15) {
                return "6-15";
            }
            else if (players <= 25) {
                return "16-25";
            }
            else if (players <= 50) {
                return "26-50";
            }
            else if (players <= 75) {
                return "51-75";
            }
            else if (players <= 100) {
                return "76-100";
            }
            else if (players <= 150) {
                return "101-150";
            }
            else if (players <= 200) {
                return "151-200";
            }
            else {
                return "200+";
            }
        });
    }

    @Override
    public String getName() {
        return "Online Players";
    }

    @Override
    public JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
