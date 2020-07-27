package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Collection {
    private Map<UUID,Armor> armorMap;
    private UberStuff plugin;

    public Collection (UberStuff plugin) {
        armorMap = new HashMap<>();
        this.plugin = plugin;
    }

    public void createArmor(Player player) {
        armorMap.put(player.getUniqueId(),new Armor(player));
        player.sendMessage(ChatColor.GRAY+plugin.getPluginConfig().getString("sit.enter","You are now sitting"));
    }

    public void removeArmor(Player player) {
        armorMap.get(player.getUniqueId()).remove();
        armorMap.remove(player.getUniqueId());
        player.sendMessage(ChatColor.GRAY+plugin.getPluginConfig().getString("sit.leave","You are now standing"));
    }

    public Armor getArmor(Player player) {
        return armorMap.get(player.getUniqueId());
    }

    public Map<UUID,Armor> getArmorMap() {
        return  armorMap;
    }

    public void clear() {
        for(Map.Entry<UUID,Armor> entry : armorMap.entrySet()) {
            entry.getValue().remove();
        }
    }

    public boolean isArmor(ArmorStand armorStand) {
        for(Map.Entry<UUID,Armor> entry : armorMap.entrySet()) {
            if(entry.getValue().getArmor().equals(armorStand)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSitting(Player player) {
        return armorMap.containsKey(player.getUniqueId());
    }
}
