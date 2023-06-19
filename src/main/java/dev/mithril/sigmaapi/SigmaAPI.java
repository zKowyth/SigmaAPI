package dev.mithril.sigmaapi;

import dev.mithril.sigmaapi.gui.SigmaItem;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SigmaAPI extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static void startSigmaAPI(Plugin plugin) {
        SigmaAPI.plugin = plugin;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
