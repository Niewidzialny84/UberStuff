package github.niewidzialny84.uberstuff;

import github.niewidzialny84.uberstuff.bucket.BucketListener;
import github.niewidzialny84.uberstuff.sit.Sit;
import github.niewidzialny84.uberstuff.util.config.Config;
import github.niewidzialny84.uberstuff.util.config.ConfigMap;
import github.niewidzialny84.uberstuff.voidfall.PlayerFall;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class UberStuff extends JavaPlugin {
    private static Config pluginConfig;

    private PlayerFall playerFall;
    private BucketListener bucketListener;
    private Sit sit;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        pluginConfig = new Config(this);
        reload();
    }

    @Override
    public void onDisable() {
        sit.clearArmors();
    }

    public void reload() {
        pluginConfig.reload();

        HandlerList.unregisterAll(this);

        if(pluginConfig.getConfigMap().getBoolean("bucket.enable",false)) {
            bucketListener = new BucketListener(this);
            this.getLogger().info("Custom bucket enabled");
        }

        if(pluginConfig.getConfigMap().getBoolean("voidfall.enable",false)) {
            playerFall = new PlayerFall(this);
            this.getLogger().info("VoidFall enabled");
        }

        if(pluginConfig.getConfigMap().getBoolean("sit.enable",false)) {
            sit = new Sit(this);
            this.getLogger().info("Sit enabled");
        }
    }

    public ConfigMap<String,Object> getPluginConfig() {
        return pluginConfig.getConfigMap();
    }

    public Config getPluginConfigClass() {
        return pluginConfig;
    }
}
