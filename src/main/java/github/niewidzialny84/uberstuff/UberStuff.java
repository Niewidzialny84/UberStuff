package github.niewidzialny84.uberstuff;

import github.niewidzialny84.uberstuff.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class UberStuff extends JavaPlugin {

    private Config pluginConfig;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        pluginConfig = new Config(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
