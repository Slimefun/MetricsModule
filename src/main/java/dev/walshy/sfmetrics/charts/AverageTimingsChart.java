package dev.walshy.sfmetrics.charts;

import dev.walshy.sfmetrics.VersionDependentChart;
import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.charts.SimplePie;
import org.bstats.json.JsonObjectBuilder;

import javax.annotation.Nonnull;

public class AverageTimingsChart extends SimplePie implements VersionDependentChart {

    public AverageTimingsChart() {
        super("average_timings", () -> {
            long averageMsTiming = SlimefunPlugin.getProfiler().getAndResetAverageTimings();

            if (averageMsTiming <= 5) {
                return "0-5";
            } else if (averageMsTiming <= 10) {
                return "6-10";
            } else if (averageMsTiming <= 15) {
                return "11-15";
            } else if (averageMsTiming <= 20) {
                return "16-20";
            } else if (averageMsTiming <= 25) {
                return "21-25";
            } else if (averageMsTiming <= 30) {
                return "26-30";
            } else if (averageMsTiming <= 35) {
                return "31-35";
            } else if (averageMsTiming <= 40) {
                return "36-40";
            } else if (averageMsTiming <= 45) {
                return "41-45";
            } else if (averageMsTiming <= 50) {
                return "46-50";

            } else if (averageMsTiming <= 75) {
                return "51-75";
            } else if (averageMsTiming <= 100) {
                return "76-100";
            } else if (averageMsTiming <= 125) {
                return "101-125";
            } else if (averageMsTiming <= 150) {
                return "126-150";
            } else {
                return "150+";
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
