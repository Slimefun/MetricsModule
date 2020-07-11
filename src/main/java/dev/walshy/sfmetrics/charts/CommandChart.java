package dev.walshy.sfmetrics.charts;

import io.github.thebusybiscuit.slimefun4.core.commands.SubCommand;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import org.bstats.bukkit.Metrics.AdvancedPie;

import java.util.HashMap;
import java.util.Map;

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
