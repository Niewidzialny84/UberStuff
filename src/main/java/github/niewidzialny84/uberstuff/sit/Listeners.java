package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

public class Listeners implements Listener {
    private UberStuff plugin;

    public Listeners(UberStuff plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void PlayerDismount(EntityDismountEvent e) {
        if(e.getDismounted() instanceof ArmorStand) {
            Sit.armors.removeArmor((Player)e.getEntity());
        }
    }

    @EventHandler
    public void PlayerRotate(PlayerMoveEvent e) {

        if(Sit.armors.isSitting(e.getPlayer())) {
            //System.out.println("moved inside");
            Sit.armors.rotate(e.getPlayer());
        }
    }
}
