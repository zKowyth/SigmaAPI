package dev.mithril.sigmaapi.gui;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class SigmaGUI implements Listener {

    private Inventory inventory;



    public SigmaGUI(InventoryHolder inventoryHolder, int size, String title) {
        inventory = Bukkit.getServer().createInventory(inventoryHolder, size, title);
    }

    @EventHandler
    private void onInteract(InventoryClickEvent e) {
        if (!(e.getInventory().equals(inventory))) return;

    }
}