package github.niewidzialny84.uberstuff.sit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class Armor {
    private ArmorStand armor;
    private Location location;

    public Armor(Player player) {
        this.armor = (ArmorStand)player.getWorld().spawnEntity(player.getLocation().add(0,-1.72,0), EntityType.ARMOR_STAND);
        this.location = armor.getLocation();

        armor.setVisible(false);
        armor.setVelocity(new Vector(0,0,0));
        armor.setInvulnerable(true);
        armor.setCollidable(false);
        armor.setGravity(false);
        armor.addPassenger(player);
        //armor.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET,1));
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

    public void rotate(EulerAngle angle) {
        armor.setHeadPose(angle);
    }
}
