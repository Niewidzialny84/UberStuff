package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Sit {
    private UberStuff plugin;

    public Sit(UberStuff plugin) {
        this.plugin = plugin;
    }

    public void createArmorStand(Player player) {
        Entity armor = player.getWorld().spawnEntity(player.getLocation().add(0,-1,0), EntityType.ARMOR_STAND);
        armor.addPassenger(player);
    }



}
