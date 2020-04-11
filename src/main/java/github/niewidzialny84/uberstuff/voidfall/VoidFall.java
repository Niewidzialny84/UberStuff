package github.niewidzialny84.uberstuff.voidfall;

import org.bukkit.plugin.java.JavaPlugin;

public class VoidFall extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        PlayerFall playerFall = new PlayerFall(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
