package github.niewidzialny84.uberstuff.bucket;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class BucketListener implements Listener {

    private Bucket bucket = new Bucket();

    public BucketListener(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        e.getPlayer().getInventory().addItem(bucket.getBucket());
    }


    @EventHandler
    public void playerFillClick(PlayerBucketFillEvent e) {
        Block block = e.getBlock();
        if((block.getType().equals(Material.WATER) || block.getType().equals(Material.LAVA))) {
            if (bucket.isCorrectBucket(e.getPlayer().getInventory().getItemInMainHand())) {
                e.getPlayer().getInventory().setItemInMainHand(bucket.getBucket());
            } else if (bucket.isCorrectBucket(e.getPlayer().getInventory().getItemInOffHand())) {
                e.getPlayer().getInventory().setItemInOffHand(bucket.getBucket());
            }
        }
    }
}
