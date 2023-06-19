package dev.mithril.sigmaapi.commands;

import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.Arrays;

public class SigmaCommandManager {


    /**
     * Plugin should create new object of the class
     * and use it
     * @param plugin the plugin using the api
     */
    public SigmaCommandManager(Plugin plugin) {
        setupSimpleCommandMap(plugin);
    }

    private static SimpleCommandMap scm;
    private SimplePluginManager spm;

    // Use this in the onEnable() method to register commands
    public void registerCommands(SigmaCommand... commands) {
        Arrays.stream(commands).forEach(command -> scm.register("mithril", command));
    }

    private void setupSimpleCommandMap(Plugin plugin) {
        spm = (SimplePluginManager) plugin.getServer().getPluginManager();
        Field f = null;
        try {
            f = SimplePluginManager.class.getDeclaredField("commandMap");
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setAccessible(true);
        try {
            scm = (SimpleCommandMap) f.get(spm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SimpleCommandMap getCommandMap() {
        return scm;
    }
}
