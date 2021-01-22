package dev.walshy.sfmetrics.charts;

import javax.annotation.Nonnull;

import dev.walshy.sfmetrics.VersionDependentChart;
import io.github.thebusybiscuit.slimefun4.api.ErrorReport;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import org.bstats.charts.SingleLineChart;
import org.bstats.json.JsonObjectBuilder;

/**
 * This single line graph shows the amount of {@link ErrorReport ErrorReports} generated.
 * 
 * @author TheBusyBiscuit
 *
 */
public class ErrorReportsChart extends SingleLineChart implements VersionDependentChart {

    // This needs to be static due to it being passed to the super constructor
    private static int lastValue = 0;

    public ErrorReportsChart() {
        super("error_reports", () -> {
            int currentValue = ErrorReport.count();
            int amount = currentValue - lastValue;
            lastValue = currentValue;
            return amount;
        });
    }

    @Override
    public boolean isCompatible(@Nonnull SlimefunBranch branch, int build) {
        if (branch == SlimefunBranch.DEVELOPMENT) {
            return build >= 638;
        } else if (branch == SlimefunBranch.STABLE) {
            return build >= 16;
        } else {
            return false;
        }
    }

    @Nonnull
    @Override
    public String getName() {
        return "Error-Reports";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
