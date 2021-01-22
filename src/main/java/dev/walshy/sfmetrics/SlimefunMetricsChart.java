package dev.walshy.sfmetrics;

import javax.annotation.Nonnull;

import org.bstats.charts.CustomChart;
import org.bstats.json.JsonObjectBuilder;

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
    @Nonnull
    String getName();

    /**
     * This returns the chart data, it is used for initial testing purposes
     * 
     * @throws Exception
     *             This is used for testing purposes, any {@link Exception} should be caught
     * 
     * @return The data of this chart
     */
    @Nonnull
    JsonObjectBuilder.JsonObject getDataSample() throws Exception;

}
