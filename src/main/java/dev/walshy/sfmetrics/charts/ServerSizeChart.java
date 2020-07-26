package dev.walshy.sfmetrics.charts;

import org.bstats.bukkit.Metrics.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.Server;

/**
 * This {@link SimplePie} allows us to see how big a {@link Server} is (player-wise).
 * 
 * @author TheBusyBiscuit
 *
 */
public class ServerSizeChart extends SimplePie {

    public ServerSizeChart() {
        super("server_size", () -> {
            int players = Bukkit.getOnlinePlayers().size();

            if (players < 5) {
                return "0-5";
            }

            if (players < 15) {
                return "5-15";
            }

            if (players < 25) {
                return "15-25";
            }

            if (players < 50) {
                return "25-50";
            }

            if (players < 75) {
                return "50-75";
            }

            if (players < 100) {
                return "75-100";
            }

            if (players < 150) {
                return "100-150";
            }

            if (players < 200) {
                return "150-200";
            }

            return "200+";
        });
    }

}
