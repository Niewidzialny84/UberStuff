package github.niewidzialny84.uberstuff.sit;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Collection {
    private Map<Player,Armor> armorMap;

    public Collection () {
        armorMap = new HashMap<>();
    }

    public void createArmor(Player player) {
        armorMap.put(player,new Armor(player));
        player.sendMessage(ChatColor.GRAY+"You are now sitting");
    }

    public void removeArmor(Player player) {
        armorMap.get(player).remove();
        player.sendMessage(ChatColor.GRAY+"You are now standing");
    }
}
