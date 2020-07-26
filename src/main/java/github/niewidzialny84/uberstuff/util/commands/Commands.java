package github.niewidzialny84.uberstuff.util.commands;

import github.niewidzialny84.uberstuff.UberStuff;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    UberStuff plugin;

    public Commands(UberStuff plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd != null && label != null && (sender instanceof Player || sender instanceof ConsoleCommandSender)) {
            if(sender.hasPermission("uberstuff") || sender.isOp()) {
                switch (args.length) {
                    case 0:
                    default:
                        sender.sendMessage(ChatColor.GRAY+"Avaible /uberstuff reload");
                        break;
                    case 1:
                        if(args[0] != null ) {
                            if(args[0].equalsIgnoreCase("RELOAD")) {
                                plugin.reload();
                                plugin.getLogger().info("Uberstuff reloaded");
                            }
                        }
                }


            }
        }

        return true;
    }
}
