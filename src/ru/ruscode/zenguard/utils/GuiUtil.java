package ru.ruscode.zenguard.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class GuiUtil {
    public static InventoryView mainGui(Player p){
        final Inventory inv = Bukkit.createInventory(p, 27, ChatUtil.fix("ZenGuard Protection Menu"));
        final ItemBuilder info = new ItemBuilder(Material.PAPER).setTitle("&cWykonane Akcje").addLore("").addLore("&7Zbanowani: &c");
        return p.openInventory(inv);
    }
}
