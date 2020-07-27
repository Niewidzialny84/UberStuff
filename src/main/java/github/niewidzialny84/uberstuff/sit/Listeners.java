package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

public class Listeners implements Listener {
    private UberStuff plugin;

    public Listeners(UberStuff plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    //Death and teleport automaticly dismounts player
    @EventHandler
    public void onPlayerDismount(EntityDismountEvent e) {
        if(e.getDismounted() instanceof ArmorStand && Sit.armors.isSitting((Player)e.getEntity())) {
            Sit.armors.removeArmor((Player)e.getEntity());
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (Sit.armors.getArmor(e.getPlayer()) != null) {
            Bukkit.getPluginManager().callEvent(new EntityDismountEvent(e.getPlayer(), Sit.armors.getArmor(e.getPlayer()).getArmor()));
        }
    }

    @EventHandler
    public void onPlayerManipulate(PlayerArmorStandManipulateEvent e) {
        if(Sit.armors.isArmor(e.getRightClicked())) {
            e.setCancelled(true);
        }
    }
}
