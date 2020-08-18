package dev.walshy.sfmetrics;

import org.bstats.bukkit.Metrics.CustomChart;

import com.google.gson.JsonObject;

/**
 * This represents a {@link CustomChart} from Slimefun.
 * 
 * @author TheBusyBiscuit
 *
 */
public interface SlimefunMetricsChart {

    /**
     * This returns the chart ids chart
     * 
     * @return The chart name
     */
    String getName();

    /**
     * This returns the chart data, it is used for initial testing purposes
     * 
     * @throws Exception
     *             This is used for testing purposes, any {@link Exception} should be caught
     * 
     * @return The data of this chart
     */
    JsonObject getDataSample() throws Exception;

}
