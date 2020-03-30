package github.niewidzialny84.uberstuff.bucket;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public class Bucket {

    private ItemStack bucket = new ItemStack(Material.BUCKET,1);
    private final String description = ChatColor.GRAY+"Mieści dużo płynów";
    private ShapedRecipe recipe;
    private NamespacedKey key;


    Bucket(Plugin plugin) {
        ItemMeta bucket_meta = bucket.getItemMeta();
        bucket_meta.addEnchant(Enchantment.DIG_SPEED,1,false);
        bucket_meta.setDisplayName(ChatColor.YELLOW +"Duże wiadro");
        bucket_meta.setLore(Arrays.asList(description));
        bucket_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bucket.setItemMeta(bucket_meta);

        key = new NamespacedKey(plugin,"SuperBucket");
        recipe = new ShapedRecipe(key,bucket);
        recipe.shape("   ","axa"," a ");
        recipe.setIngredient('a',Material.IRON_BLOCK);
        recipe.setIngredient('x',Material.ENDER_EYE);
        recipe.setGroup("UberStuffSpecial");

        Bukkit.addRecipe(recipe);
    }

    public boolean isCorrectBucket(ItemStack a) {
        try {
            return a.getItemMeta().getLore().get(0) != null && a.getItemMeta().getLore().get(0).equals(bucket.getItemMeta().getLore().get(0));
        } catch (NullPointerException ex) {
            return false;
        }

    }

    public ItemStack getBucket() {
        return bucket;
    }

    public ShapedRecipe getRecipe() {
        return recipe;
    }

    public NamespacedKey getKey() {
        return key;
    }
}