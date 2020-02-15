package github.niewidzialny84.uberstuff.bucket;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Bucket {

    private ItemStack bucket = new ItemStack(Material.BUCKET,1);
    private ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET,1);
    private ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET,1);
    private static int maxCapacity = 10;
    private int currentCapacity = 0;
    private static String description = ChatColor.GRAY+"Mieści dużo płynów";
    private String status;

    Bucket() {
        ItemMeta bucket_meta = bucket.getItemMeta();
        bucket_meta.addEnchant(Enchantment.DIG_SPEED,1,false);
        bucket_meta.setDisplayName(ChatColor.YELLOW +"Duże puste wiadro");
        status = ChatColor.GRAY+"Zajęte "+ChatColor.BOLD+currentCapacity+"/"+maxCapacity;
        bucket_meta.setLore(Arrays.asList(description,status));
        bucket_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bucket.setItemMeta(bucket_meta);
        bucket_meta.setDisplayName(ChatColor.YELLOW +"Duże wiadro lavy");
        lavaBucket.setItemMeta(bucket_meta);
        bucket_meta.setDisplayName(ChatColor.YELLOW +"Duże wiadro wody");
        waterBucket.setItemMeta(bucket_meta);
    }

    public void setStatus(int currentCapacity) {
        setBucketStatus(this.bucket,currentCapacity);
        setBucketStatus(this.lavaBucket,currentCapacity);
        setBucketStatus(this.waterBucket,currentCapacity);
    }

    public static ItemStack setBucketStatus(ItemStack bucket, int currentCapacity) {
        ItemMeta bucket_meta = bucket.getItemMeta();
        String status = ChatColor.GRAY+"Zajęte "+ChatColor.BOLD+currentCapacity+"/"+maxCapacity;
        bucket_meta.setLore(Arrays.asList(description,status));
        bucket.setItemMeta(bucket_meta);
        return bucket;
    }

    public static boolean isCorrectBucket(ItemStack a,ItemStack b) {
        ItemMeta aMeta = a.getItemMeta();
        ItemMeta bMeta = b.getItemMeta();

        if(aMeta.getLore().get(0).equals(bMeta.getLore().get(0))) {
            return true;
        }

        return false;
    }

    public ItemStack getBucket() {
        return bucket;
    }

    public ItemStack getWaterBucket() {
        return waterBucket;
    }

    public ItemStack getLavaBucket() {
        return lavaBucket;
    }
}