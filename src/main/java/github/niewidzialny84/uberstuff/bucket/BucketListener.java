package github.niewidzialny84.uberstuff.bucket;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class BucketListener implements Listener {

    BucketListener(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        e.getPlayer().getInventory().setItemInOffHand(new Bucket().getBucket());
    }


    @EventHandler
    public void playerRightClick(PlayerBucketFillEvent e) {

    }
}
