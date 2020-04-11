package github.niewidzialny84.uberstuff.voidfall;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;


public class PlayerFall implements Listener {
    private Plugin plugin;

    public PlayerFall(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this,plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onVoidDamage(EntityDamageEvent e) {
        if(e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
            if(e.getEntity() instanceof Player) {
                Player player = (Player)e.getEntity();

                int y = player.getLocation().getBlockY();

                if(player.isOnline() && player.getWorld().getEnvironment().equals(World.Environment.THE_END) && y < -50) {
                    String worldName = plugin.getConfig().getString("voidfall.worldName","world");

                    Location loc = player.getLocation();
                    loc.setWorld(Bukkit.getWorld(worldName));
                    loc.add(0,500,0);

                    player.teleport(loc);
                    new SoundEffect(player).runTaskLater(plugin,10);

                    if(plugin.getConfig().getBoolean("voidfall.doVoidout",false)) {
                        new VoidOut(plugin, player).runTaskLater(plugin, 15);
                    }
                }
            }
        }
    }
}