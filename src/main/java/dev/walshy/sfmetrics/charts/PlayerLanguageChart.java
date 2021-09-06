package dev.walshy.sfmetrics.charts;

import java.util.HashMap;
import java.util.Map;

import org.bstats.charts.AdvancedPie;
import org.bstats.json.JsonObjectBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import dev.walshy.sfmetrics.SlimefunMetricsChart;
import io.github.thebusybiscuit.slimefun4.core.services.localization.Language;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;

import javax.annotation.Nonnull;

/**
 * This {@link AdvancedPie} allows us to see what {@link Language Languages} are selected by
 * {@link Player Players}.
 * 
 * @author TheBusyBiscuit
 *
 */
public class PlayerLanguageChart extends AdvancedPie implements SlimefunMetricsChart {

    public PlayerLanguageChart() {
        super("player_languages", () -> {
            Map<String, Integer> languages = new HashMap<>();

            for (Player p : Bukkit.getOnlinePlayers()) {
                Language language = Slimefun.getLocalization().getLanguage(p);
                boolean supported = Slimefun.getLocalization().isLanguageLoaded(language.getId());

                String lang = supported ? language.getId() : "Unsupported Language";
                languages.merge(lang, 1, Integer::sum);
            }

            return languages;
        });
    }

    @Nonnull
    @Override
    public String getName() {
        return "Player Languages";
    }

    @Nonnull
    @Override
    public JsonObjectBuilder.JsonObject getDataSample() throws Exception {
        return getChartData();
    }

}
