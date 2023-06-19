package dev.mithril.sigmaapi;

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


    /**
     * Method to use to initialize the API,
     * To be put in the onEnable() of the plugin
     * @param plugin Plugin that uses the API
     */
    public static void startSigmaAPI(Plugin plugin) {
        SigmaAPI.plugin = plugin;
    }

    /**
     * Returns the plugin that uses the API.
     * Not intended to be used by the plugin.
     * @return the plugin using the API
     */
    public static Plugin getPlugin() {
        return plugin;
    }
}
