package dev.mithril.sigmaapi;

import dev.mithril.sigmaapi.gui.SigmaItem;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SigmaAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void startSigmaAPI(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new SigmaItem(), plugin);
    }
}
