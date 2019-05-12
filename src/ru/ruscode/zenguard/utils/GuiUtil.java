package ru.ruscode.zenguard.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class GuiUtil {
    public static InventoryView mainGui(Player p){
        final Inventory inv = Bukkit.createInventory(p, 27, ChatUtil.fix(ConfigUtils.getString("messages.gui-name")));
        final ItemBuilder none = new ItemBuilder(Material.BARRIER).setTitle(ChatUtil.fix("&4Coming Soon")).addLore(" ");
        final ItemBuilder status = new ItemBuilder(Material.EYE_OF_ENDER).setTitle(ChatUtil.fix(ConfigUtils.getString("gui.status.name"))).addLore(" ").addLore(ChatUtil.fix("&7TPS: &6" + ChatUtil.percentFormat(TpsUtils.getTPS()))).addLore(ChatUtil.fix("&7Free RAM: &c" + TpsUtils.readableByteCount(Runtime.getRuntime().freeMemory())));
        final ItemBuilder stats = new ItemBuilder(Material.PAPER).setTitle(ChatUtil.fix(ConfigUtils.getString("gui.actions.name"))).addLore(ChatUtil.fix("")).addLore(ChatUtil.fix("&7OP-Protection: &c") + ConfigUtils.getString("stats.op-protection"));
        inv.setItem(16, stats.build());
        inv.setItem(14, status.build());
        inv.setItem(12, none.build());
        inv.setItem(10, none.build());
        return p.openInventory(inv);
    }
}
