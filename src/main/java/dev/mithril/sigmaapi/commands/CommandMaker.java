package dev.mithril.utils;

import dev.mithril.RoleplayFeatures;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;

public abstract class CommandMaker extends Command implements PluginIdentifiableCommand {
    CommandSender sender;
    RoleplayFeatures plugin = RoleplayFeatures.getInstance();
    protected CommandMaker(String name) {
        super(name);
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    public abstract void run(CommandSender sender, String commandLabel, String[] arguments);

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] arguments) {
        this.sender = sender;
        run(sender, commandLabel, arguments);
        return true;
    }
}