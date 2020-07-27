package github.niewidzialny84.uberstuff.bucket;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class BucketListener implements Listener {

    private Bucket bucket;

    public BucketListener(UberStuff plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        bucket = new Bucket(plugin);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        e.getPlayer().discoverRecipe(bucket.getKey());
    }


    @EventHandler
    public void playerFillClick(PlayerBucketFillEvent e) {
        Block block = e.getBlock();
        boolean mainHand = false;
        if (bucket.isCorrectBucket(e.getPlayer().getInventory().getItemInMainHand()) || bucket.isCorrectBucket(e.getPlayer().getInventory().getItemInOffHand())) {
            if(bucket.isCorrectBucket(e.getPlayer().getInventory().getItemInMainHand())) {
                mainHand = true;
            }

            if(e.getItemStack().equals(new ItemStack(Material.MILK_BUCKET,1))) {
                e.setCancelled(true);
                e.getPlayer().updateInventory();
                return;
            }

            BlockData blockData = block.getBlockData();
            if(blockData instanceof Waterlogged) {
                if (((Waterlogged)blockData).isWaterlogged()) {
                    e.setCancelled(true);
                    ((Waterlogged)blockData).setWaterlogged(false);
                    block.setBlockData(blockData);
                    replaceHand(e.getPlayer(),mainHand);
                    return;
                }
            }

            if((block.getType().equals(Material.WATER) || block.getType().equals(Material.LAVA))) {
                e.setCancelled(true);
                block.setType(Material.AIR);
                replaceHand(e.getPlayer(),mainHand);
                if(e.getPlayer().isSneaking()) {
                    for(int x = -1; x<= 1;x++) {
                        for(int y = -1; y<=1; y++) {
                            for(int z = -1; z<=1; z++) {
                                Block tmpBlock = block.getLocation().add(x,y,z).getBlock();
                                if(tmpBlock.getType().equals(Material.LAVA) ||tmpBlock.getType().equals(Material.WATER)) {
                                    tmpBlock.setType(Material.AIR);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

   @EventHandler
    public void cauldronFill(CauldronLevelChangeEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = ((Player) e.getEntity()).getPlayer();
            Block block = e.getBlock();
            BlockData blockData = block.getBlockData();
            if (e.getReason().equals(CauldronLevelChangeEvent.ChangeReason.BUCKET_FILL) && (bucket.isCorrectBucket(player.getInventory().getItemInMainHand()) || bucket.isCorrectBucket(player.getInventory().getItemInOffHand()))) {
                e.setCancelled(true);
                if(blockData instanceof Levelled && block.getType().equals(Material.CAULDRON)) {
                    Levelled cauldronData = (Levelled) blockData;
                    if(cauldronData.getLevel() == cauldronData.getMaximumLevel()) {
                        cauldronData.setLevel(0);
                        block.setBlockData(cauldronData);
                    }
                }
            }
        }
    }

    @EventHandler
    public void dispenserFill(BlockDispenseEvent e) {
        if (bucket.isCorrectBucket(e.getItem())) {
            Dispenser dispenser = (Dispenser) e.getBlock().getState();
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryUse(InventoryClickEvent e) {
        if (e.getClickedInventory() != null) {
            if (e.getClickedInventory().getType() == InventoryType.GRINDSTONE || e.getClickedInventory().getType() == InventoryType.ANVIL) {
                if(e.getSlotType() == InventoryType.SlotType.CRAFTING && bucket.isCorrectBucket(e.getCursor())) {
                    e.setCancelled(true);
                }
            } else if(e.getClickedInventory().getType() == InventoryType.PLAYER && e.isShiftClick()) {
                if((e.getView().getTopInventory().getType() == InventoryType.GRINDSTONE || e.getView().getTopInventory().getType() == InventoryType.ANVIL) && bucket.isCorrectBucket(e.getCurrentItem())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    private void replaceHand(Player player,boolean mainHand) {
        if(mainHand) {
            player.getInventory().setItemInMainHand(bucket.updateBucket(player.getInventory().getItemInMainHand()));
        } else {
            player.getInventory().setItemInOffHand(bucket.updateBucket(player.getInventory().getItemInOffHand()));
        }
    }
}
