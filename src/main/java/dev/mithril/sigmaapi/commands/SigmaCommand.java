package dev.mithril.sigmaapi.commands;

import dev.mithril.sigmaapi.SigmaAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

public abstract class SigmaCommand extends Command implements PluginIdentifiableCommand {
    CommandSender sender;
    protected SigmaCommand(String name) {
        super(name);
    }

    public abstract void run(CommandSender sender, String commandLabel, String[] arguments);

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String commandLabel, @Nonnull String[] arguments) {
        this.sender = sender;
        run(sender, commandLabel, arguments);
        return true;
    }

    @Override
    public @Nonnull Plugin getPlugin() {
        return SigmaAPI.getPlugin();
    }

    public void sendSenderMessage(String message) {
        sender.sendMessage(message);
    }
}