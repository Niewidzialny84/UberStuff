package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.UUID;

public class RotateTask extends BukkitRunnable {
    private UberStuff plugin;

    RotateTask(UberStuff plugin) {
        this.plugin = plugin;
        runTaskTimerAsynchronously(plugin,0L,1L);
    }

    @Override
    public void run() {
        for(Map.Entry<UUID,Armor> entry: Sit.armors.getArmorMap().entrySet()) {
            entry.getValue().rotate();
        }
    }
}
