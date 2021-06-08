package dev.walshy.sfmetrics.charts;

import dev.walshy.sfmetrics.VersionDependentChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;

import javax.annotation.Nonnull;

public class AverageTimingsChart extends SimplePie implements VersionDependentChart {

    // If there's more than 15 values bStats will create an "Other" section (which cannot be viewed)
    // So we make sure there's 15 or less (currently, 13 values)
    public AverageTimingsChart() {
        super("average_timings", () -> {
            long averageMsTiming = 0;
            try {
                averageMsTiming = SlimefunPlugin.getProfiler().getAndResetAverageTimings();
            } catch (ArithmeticException e) {
                // I forgot we test this on startup when the timing would be 0.
                // This is a quick and dirty fix - thank god for easy module stuff
            }

            // 10ms diffs
            if (averageMsTiming <= 10) {
                return "0-10";
            } else if (averageMsTiming <= 20) {
                return "11-20";
            } else if (averageMsTiming <= 30) {
                return "21-30";
            } else if (averageMsTiming <= 40) {
                return "31-40";
            } else if (averageMsTiming <= 50) {
                return "41-50";

                // 25ms diffs
            } else if (averageMsTiming <= 75) {
                return "51-75";
            } else if (averageMsTiming <= 100) {
                return "76-100";
            } else if (averageMsTiming <= 125) {
                return "101-125";
            } else if (averageMsTiming <= 150) {
                return "126-150";
            } else if (averageMsTiming <= 175) {
                return "151-175";
            } else if (averageMsTiming <= 200) {
                return "176-200";

                // 50ms
            } else if (averageMsTiming <= 250) {
                return "201-250";

                // Other
            } else {
                return "> 250";
            }
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Average SF Tick (ms)";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

    @Override
    public boolean isCompatible(@Nonnull SlimefunBranch branch, int build) {
        if (branch == SlimefunBranch.STABLE && build >= 25) {
            return true;
        } else {
            return branch == SlimefunBranch.DEVELOPMENT && build >= 933;
        }
    }
}
