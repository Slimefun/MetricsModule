package dev.walshy.sfmetrics;

import org.bstats.bukkit.Metrics.CustomChart;

import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;

/**
 * This {@link FunctionalInterface} marks a {@link CustomChart} as dependent on specific
 * versions of Slimefun.
 * 
 * @author TheBusyBiscuit
 *
 */
@FunctionalInterface
public interface VersionDependentChart {

    boolean isCompatible(SlimefunBranch branch, int build);

}
