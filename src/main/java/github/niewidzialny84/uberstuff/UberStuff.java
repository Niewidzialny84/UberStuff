package github.niewidzialny84.uberstuff;

import github.niewidzialny84.uberstuff.util.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class UberStuff extends JavaPlugin {

    private static Config pluginConfig;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        pluginConfig = new Config(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Config getPluginConfig() {
        return pluginConfig;
    }
}
