package github.niewidzialny84.uberstuff.util.config;

import github.niewidzialny84.uberstuff.UberStuff;
import github.niewidzialny84.uberstuff.util.commands.Commands;
import github.niewidzialny84.uberstuff.util.commands.CommandsTab;

import java.util.Map;

public class Config {
    private UberStuff plugin;
    private ConfigMap<String,Object> configMap;

    public Config(UberStuff plugin) {
        this.plugin = plugin;

        plugin.getCommand("uberstuff").setExecutor(new Commands(plugin));
        plugin.getCommand("uberstuff").setTabCompleter(new CommandsTab());

        reload();
    }

    public void reload() {
        plugin.reloadConfig();

        Map<String,Object> map = plugin.getConfig().getValues(true);

        configMap = new ConfigMap<>();

        for(Map.Entry<String, Object> entry: map.entrySet()) {
            configMap.put(entry.getKey(),entry.getValue());
        }
    }

    public ConfigMap<String, Object> getConfigMap() {
        return configMap;
    }
}
