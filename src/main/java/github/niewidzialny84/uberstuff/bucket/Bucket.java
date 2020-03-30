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
    private static String description = ChatColor.GRAY+"Mieści dużo płynów";

    Bucket() {
        ItemMeta bucket_meta = bucket.getItemMeta();
        bucket_meta.addEnchant(Enchantment.DIG_SPEED,1,false);
        bucket_meta.setDisplayName(ChatColor.YELLOW +"Duże wiadro");
        bucket_meta.setLore(Arrays.asList(description));
        bucket_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bucket.setItemMeta(bucket_meta);
    }

    public boolean isCorrectBucket(ItemStack a) {
        return a.getItemMeta().getLore().get(0) != null && a.getItemMeta().getLore().get(0).equals(bucket.getItemMeta().getLore().get(0));
    }

    public ItemStack getBucket() {
        return bucket;
    }
}