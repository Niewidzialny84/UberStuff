package github.niewidzialny84.uberstuff;

import github.niewidzialny84.uberstuff.bucket.BucketListener;
import github.niewidzialny84.uberstuff.voidfall.PlayerFall;
import org.bukkit.plugin.java.JavaPlugin;

public final class UberStuff extends JavaPlugin {

    @Override
    public void onEnable() {
        new BucketListener(this);
        new PlayerFall(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
