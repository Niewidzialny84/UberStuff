package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Collection {
    private Map<Player,Armor> armorMap;
    private UberStuff plugin;

    public Collection (UberStuff plugin) {
        armorMap = new HashMap<>();
        this.plugin = plugin;
    }

    public void createArmor(Player player) {
        armorMap.put(player,new Armor(player));
        player.sendMessage(ChatColor.GRAY+plugin.getPluginConfig().getString("sit.enter","You are now sitting"));
    }

    public void removeArmor(Player player) {
        armorMap.get(player).remove();
        player.sendMessage(ChatColor.GRAY+plugin.getPluginConfig().getString("sit.leave","You are now standing"));
    }
}
