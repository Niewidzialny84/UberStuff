package github.niewidzialny84.uberstuff.voidfall;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SoundEffect extends BukkitRunnable {

    Player player;

    public SoundEffect(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        player.setFoodLevel(1);
        player.setSaturation(0);
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,100,1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,60,1));
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BIG_FALL,10f,1f);
        player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE,10f,1f);
    }

}
