package github.niewidzialny84.uberstuff;

import github.niewidzialny84.uberstuff.bucket.BucketListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class UberStuff extends JavaPlugin {

    @Override
    public void onEnable() {
        new BucketListener(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
