package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SitCommand implements CommandExecutor {
    private UberStuff plugin;

    public SitCommand(UberStuff plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd != null && label != null && (sender instanceof Player)) {
            if(sender.hasPermission("uberstuff-sit") || sender.isOp()) {
                switch (args.length) {
                    case 0:
                    default:
                        new Sit(plugin).createArmorStand((Player)sender);
                        sender.sendMessage(ChatColor.GRAY+"You are now sitting");
                        break;
                }


            }
        }

        return true;
    }
}