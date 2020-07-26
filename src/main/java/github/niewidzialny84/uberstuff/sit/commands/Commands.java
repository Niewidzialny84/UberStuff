package github.niewidzialny84.uberstuff.sit.commands;

import github.niewidzialny84.uberstuff.UberStuff;
import github.niewidzialny84.uberstuff.sit.Sit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    private UberStuff plugin;

    public Commands(UberStuff plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if(cmd != null && label != null && (sender instanceof Player)) {
            if(sender.hasPermission("uberstuff-sit") || sender.isOp()) {
                switch (args.length) {
                    case 0:
                    default:
                        Sit.armors.createArmor((Player)sender);
                        break;
                }


            }
        }

        return true;
    }
}