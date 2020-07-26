package github.niewidzialny84.uberstuff.sit;

import github.niewidzialny84.uberstuff.UberStuff;
import github.niewidzialny84.uberstuff.sit.commands.Commands;
import github.niewidzialny84.uberstuff.sit.commands.CommandsTab;

public class Sit {
    private UberStuff plugin;
    private Listeners listeners;
    public static Collection armors;

    public Sit(UberStuff plugin) {
        this.plugin = plugin;

        armors = new Collection(plugin);
        listeners = new Listeners(plugin);
        plugin.getCommand("sit").setExecutor(new Commands(plugin));
        plugin.getCommand("sit").setTabCompleter(new CommandsTab());
    }

    public void clearArmors() {
        armors.clear();
        armors = new Collection(plugin);
    }

}
