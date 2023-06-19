package dev.mithril.sigmaapi.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class SigmaGUI {

    private final Inventory inventory;


    public SigmaGUI(InventoryHolder inventoryHolder, int rows, String title) {
        inventory = Bukkit.getServer().createInventory(inventoryHolder, rows*9, title);
    }


    public void addItem(SigmaItem item) {
        inventory.addItem(item.getItemStack());
    }
    public void setItem(int slot, SigmaItem item) {
        inventory.setItem(slot, item.getItemStack());
    }
    public ItemStack getItem(int slot) {
        return inventory.getItem(slot);
    }
    public ItemStack[] getContents() {
        return inventory.getContents();
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }


    public Inventory getInventory() {
        return inventory;
    }
}