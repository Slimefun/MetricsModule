package dev.walshy.sfmetrics.charts;

import java.util.HashMap;
import java.util.Map;

import org.bstats.bukkit.Metrics.AdvancedPie;

import io.github.thebusybiscuit.slimefun4.core.commands.SubCommand;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;

/**
 * This {@link AdvancedPie} shows us what {@link SubCommand} of Slimefun is run very often.
 * 
 * This allows us to see what {@link SubCommand commands} are used more often than others.
 * 
 * @author TheBusyBiscuit
 *
 */
public class CommandChart extends AdvancedPie {

    public CommandChart() {
        super("commands_ran", () -> {
            Map<String, Integer> commands = new HashMap<>();

            for (Map.Entry<SubCommand, Integer> entry : SlimefunPlugin.getCommand().getCommandUsage().entrySet()) {
                commands.put("/sf " + entry.getKey().getName(), entry.getValue());
            }

            return commands;
        });
    }

}
