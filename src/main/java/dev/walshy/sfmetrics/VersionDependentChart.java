package dev.walshy.sfmetrics;

import javax.annotation.Nonnull;

import io.github.thebusybiscuit.slimefun4.api.SlimefunBranch;

/**
 * This interface marks a {@link SlimefunMetricsChart} as dependent on specific
 * versions of Slimefun.
 * 
 * @author TheBusyBiscuit
 *
 */
public interface VersionDependentChart extends SlimefunMetricsChart {

    /**
     * This method checks if this chart is compatible with the given installation of
     * Slimefun.
     * 
     * @param branch
     *            The {@link SlimefunBranch} of this version
     * @param build
     *            The build number of this version
     * 
     * @return Whether this chart is compatible
     */
    boolean isCompatible(@Nonnull SlimefunBranch branch, int build);

}
