package dev.mithril.sigmaapi.gui;

import dev.mithril.sigmaapi.SigmaAPI;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class SigmaItem implements Listener {

    private ItemStack itemStack;

    private ItemMeta meta;

    private boolean cancelClick = true;

    private ClickListener listener;

    public SigmaItem(Material material) {
        itemStack = new ItemStack(material);
    }
    public SigmaItem(Material material, String displayName) {
        itemStack = new ItemStack(material);
        meta = itemStack.getItemMeta();
        meta.setDisplayName(displayName);
        itemStack.setItemMeta(meta);
    }
    public SigmaItem(Material material, String displayName, String... lore) {
        itemStack = new ItemStack(material);
        meta = itemStack.getItemMeta();
        meta.setDisplayName(displayName);
        List<String> loreList = Arrays.asList(lore);
        meta.setLore(loreList);
        itemStack.setItemMeta(meta);
    }

    public SigmaItem whenClicked(ClickListener listener) {
        this.listener = listener;
        SigmaAPI.getPlugin().getServer().getPluginManager().registerEvents(this, SigmaAPI.getPlugin());
        return this;
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.AIR)) return;
        if (!(e.getCurrentItem().equals(itemStack))) return;
        listener.clickEvent(e);
        if (cancelClick) e.setCancelled(true);
    }

    public SigmaItem doNotCancel() {
        cancelClick = false;
        return this;
    }

    public ClickListener getListener() {
        return listener;
    }

    public ItemMeta getMeta() {
        return meta;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
