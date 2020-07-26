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
    private ConfigMap<String,Object> configMap;
    private PlayerFall playerFall;
    private BucketListener bucketListener;

    public Config(UberStuff plugin) {
        this.plugin = plugin;

        plugin.getCommand("uberstuff").setExecutor(new Commands(plugin));
        plugin.getCommand("uberstuff").setTabCompleter(new CommandsTab());

        configMap = new ConfigMap<>();
        reload();
    }

    public void reload() {
        plugin.reloadConfig();

        Map<String,Object> map = plugin.getConfig().getValues(true);

        for(Map.Entry<String, Object> entry: map.entrySet()) {
            configMap.put(entry.getKey(),entry.getValue());
        }

        HandlerList.unregisterAll(plugin);

        if(configMap.getBoolean("bucket.enable",false)) {
            bucketListener = new BucketListener(plugin);
            plugin.getLogger().info("Custom bucket enabled");
        }

        if(configMap.getBoolean("voidfall.enable",false)) {
            playerFall = new PlayerFall(plugin);
            plugin.getLogger().info("VoidFall enabled");
        }
    }

    public ConfigMap<String, Object> getConfigValue() {
        return configMap;
    }
}
