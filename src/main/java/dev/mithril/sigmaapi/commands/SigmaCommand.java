package dev.mithril.sigmaapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;

public abstract class SigmaCommand extends Command implements PluginIdentifiableCommand {
    CommandSender sender;
    protected SigmaCommand(String name) {
        super(name);
    }

    public abstract void run(CommandSender sender, String commandLabel, String[] arguments);

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] arguments) {
        this.sender = sender;
        run(sender, commandLabel, arguments);
        return true;
    }


    public void sendSenderMessage(String message) {
        sender.sendMessage(message);
    }
}