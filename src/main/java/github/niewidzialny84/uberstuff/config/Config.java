package github.niewidzialny84.uberstuff.config;

import github.niewidzialny84.uberstuff.bucket.BucketListener;
import github.niewidzialny84.uberstuff.voidfall.PlayerFall;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Plugin plugin;
    private static Map<String,Object> configValue;
    private static PlayerFall playerFall;
    private static BucketListener bucketListener;

    public Config(Plugin plugin) {
        this.plugin = plugin;
        configValue = new HashMap<>();
        reload();
    }

    public void reload() {
        plugin.reloadConfig();
        configValue = plugin.getConfig().getValues(true);

        HandlerList.unregisterAll(plugin);

        if((Boolean) configValue.get("bucket.enable")) {
            bucketListener = new BucketListener(plugin);
            plugin.getLogger().info("Custom bucket enabled");
        }

        if((Boolean) configValue.get("voidfall.enable")) {
            playerFall = new PlayerFall(plugin);
            plugin.getLogger().info("VoidFall enabled");
        }

    }

    public static Map<String, Object> getConfigValue() {
        return configValue;
    }
}
