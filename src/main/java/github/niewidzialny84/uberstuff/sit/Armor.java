package github.niewidzialny84.uberstuff.sit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class Armor {
    private ArmorStand armor;
    private Location location;
    private Player player;

    public Armor(Player player) {
        Location location = player.getLocation().subtract(0,1.705,0);
        this.armor = (ArmorStand)player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        this.location = armor.getLocation();
        this.player = player;

        armor.setVisible(false);
        armor.setInvulnerable(true);
        armor.setCollidable(false);
        armor.setGravity(false);
        armor.setBasePlate(false);
        armor.addPassenger(player);
        //.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET,1));
    }

    public ArmorStand getArmor() {
        return armor;
    }

    public Entity getEntity() {
        return armor;
    }

    public Location getLocation() {
        return location;
    }

    public void remove() {
        armor.remove();
    }

    public void rotate() {
        try {
            Object entityArmorstand = armor.getClass().getMethod("getHandle", new Class[0]).invoke(armor, new Object[0]);
            Field yaw = entityArmorstand.getClass().getField("yaw");
            yaw.set(entityArmorstand, player.getLocation().getYaw());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
