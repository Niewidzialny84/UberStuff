package github.niewidzialny84.uberstuff.bucket;

import org.bukkit.Bukkit;
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
        e.getPlayer().getInventory().addItem(bucket.getBucket(),bucket.getLavaBucket(),bucket.getWaterBucket());
    }


    @EventHandler
    public void playerFillClick(PlayerBucketFillEvent e) {
        ItemStack hand = e.getPlayer().getInventory().getItemInMainHand();
        if(Bucket.isCorrectBucket(hand,bucket.getBucket())) {
            System.out.println("puste");
        } else if (Bucket.isCorrectBucket(hand,bucket.getLavaBucket())) {
            System.out.println("lava");
        } else if (Bucket.isCorrectBucket(hand,bucket.getWaterBucket())) {
            System.out.println("woda");
        }

    }
}
