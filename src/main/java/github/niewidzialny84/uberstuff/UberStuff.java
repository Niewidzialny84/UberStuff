package github.niewidzialny84.uberstuff;

import github.niewidzialny84.uberstuff.bucket.BucketListener;
import github.niewidzialny84.uberstuff.voidfall.PlayerFall;
import org.bukkit.plugin.java.JavaPlugin;

public final class UberStuff extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        new PlayerFall(this);

        System.out.println(this.getConfig().getValues(true));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
