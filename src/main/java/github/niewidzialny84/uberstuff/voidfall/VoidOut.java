package github.niewidzialny84.uberstuff.voidfall;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class VoidOut extends BukkitRunnable {
    Player player;

    public VoidOut(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        Chunk chunk = player.getLocation().getChunk();

        for(int x = 0; x<= 15;x++) {
            for(int z = 0;z <= 15;z++) {
                for(int y = 1;y <= 255; y++) {
                    chunk.getBlock(x,y,z).setType(Material.AIR);
                }
            }
        }
    }
}
