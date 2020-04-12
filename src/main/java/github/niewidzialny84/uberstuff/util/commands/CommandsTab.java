package github.niewidzialny84.uberstuff.util.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandsTab implements TabCompleter {
    private final static List<String> EMPTY = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getLabel().equalsIgnoreCase(label)) {
            switch(args.length) {
                case 0:
                    return Arrays.asList("reload");
            }
        }


        return EMPTY;
    }
}
