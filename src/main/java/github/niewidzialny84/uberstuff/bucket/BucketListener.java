package github.niewidzialny84.uberstuff.bucket;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
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

        if (bucket.isCorrectBucket(e.getPlayer().getInventory().getItemInMainHand()) || bucket.isCorrectBucket(e.getPlayer().getInventory().getItemInOffHand())) {
            if(e.getItemStack().equals(new ItemStack(Material.MILK_BUCKET,1))) {
                e.setCancelled(true);
                return;
            }

            BlockData blockData = block.getBlockData();
            if(blockData instanceof Waterlogged) {
                if (((Waterlogged)blockData).isWaterlogged()) {
                    e.setCancelled(true);
                    ((Waterlogged)blockData).setWaterlogged(false);
                    block.setBlockData(blockData);
                    return;
                }
            }

            if((block.getType().equals(Material.WATER) || block.getType().equals(Material.LAVA))) {
                e.setCancelled(true);
                block.setType(Material.AIR);
            }
        }
    }
}
