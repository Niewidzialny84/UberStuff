package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

    //TODO: add death quit teleport events and manipulate event is not existing go async mode
}
