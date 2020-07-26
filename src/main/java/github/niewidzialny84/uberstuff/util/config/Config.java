package github.niewidzialny84.uberstuff.util.config;

import github.niewidzialny84.uberstuff.UberStuff;
import github.niewidzialny84.uberstuff.bucket.BucketListener;
import github.niewidzialny84.uberstuff.util.commands.Commands;
import github.niewidzialny84.uberstuff.util.commands.CommandsTab;
import github.niewidzialny84.uberstuff.voidfall.PlayerFall;
import org.bukkit.event.HandlerList;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private UberStuff plugin;
    private static Map<String,Object> configValue;
    private static PlayerFall playerFall;
    private static BucketListener bucketListener;

    public Config(UberStuff plugin) {
        this.plugin = plugin;

        plugin.getCommand("uberstuff").setExecutor(new Commands(plugin));
        plugin.getCommand("uberstuff").setTabCompleter(new CommandsTab());

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
