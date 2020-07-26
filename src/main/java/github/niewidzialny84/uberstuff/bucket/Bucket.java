package github.niewidzialny84.uberstuff.bucket;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Bucket{

    private ItemStack bucket = new ItemStack(Material.BUCKET,1);
    private String description;
    private String name;
    private int durability;
    private ShapedRecipe recipe;
    private NamespacedKey key;


    Bucket(UberStuff plugin) {
        name = ChatColor.YELLOW + plugin.getPluginConfig().getString("bucket.name","Duże wiadro");
        description = ChatColor.GRAY + plugin.getPluginConfig().getString("bucket.description", "Pochłania płyny");
        durability = plugin.getPluginConfig().getInt("bucket.durability",100);

        String capacityDescription = ChatColor.DARK_GRAY+""+durability;

        ItemMeta bucket_meta = bucket.getItemMeta();
        bucket_meta.addEnchant(Enchantment.DIG_SPEED,1,false);
        bucket_meta.setDisplayName(name);
        bucket_meta.setLore(Arrays.asList(description,capacityDescription));
        bucket_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bucket.setItemMeta(bucket_meta);

        key = new NamespacedKey(plugin,"SuperBucket");
        recipe = new ShapedRecipe(key,bucket);
        recipe.shape("   ","axa"," a ");
        recipe.setIngredient('a',Material.IRON_BLOCK);
        recipe.setIngredient('x',Material.ENDER_EYE);
        recipe.setGroup("UberStuffSpecial");

        Bukkit.removeRecipe(key);
        Bukkit.addRecipe(recipe);
    }

    public boolean isCorrectBucket(ItemStack a) {
        try {
            return a.getItemMeta().getLore().get(0) != null && a.getItemMeta().getLore().get(0).equals(description) && a.getItemMeta().getDisplayName().equals(name);
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public ItemStack updateBucket(ItemStack oldBucket) {
        ItemMeta oldMeta = oldBucket.getItemMeta();
        int current = Integer.parseInt(oldMeta.getLore().get(1).substring(2))-1;

        if(current == 0) {
            if(oldBucket.getAmount() == 1) {
                return new ItemStack(Material.AIR, 1);
            } else {
                oldBucket.setAmount(oldBucket.getAmount()-1);
                current = durability;
            }
        }

        String capacityDescription = ChatColor.DARK_GRAY+""+current;
        oldMeta.setLore(Arrays.asList(description,capacityDescription));
        oldBucket.setItemMeta(oldMeta);
        return oldBucket;
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