package github.niewidzialny84.uberstuff.bucket;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public final class Bucket {

    ItemStack bucket = new ItemStack(Material.BUCKET,1);
    List<String> lore = new ArrayList<>(Arrays.asList(new String[]{"Mieści dużo płynów","Zajęte: 0/10"}));

    Bucket() {
        ItemMeta bucket_meta = bucket.getItemMeta();
        bucket_meta.addEnchant(Enchantment.DIG_SPEED,1,false);
        bucket_meta.setDisplayName(Color.TEAL +"Duże wiadro");
        bucket_meta.setLore(lore);
    }
}