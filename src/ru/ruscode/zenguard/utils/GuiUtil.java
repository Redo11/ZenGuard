package ru.ruscode.zenguard.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import ru.ruscode.zenguard.Main;

public class GuiUtil {
    public static InventoryView mainGui(Player p){
        final Inventory inv = Bukkit.createInventory(p, 27, ChatUtil.fix(ConfigUtils.getString("messages.gui-name")));
        final ItemBuilder none = new ItemBuilder(Material.BARRIER).setTitle(ChatUtil.fix("&4Coming Soon")).addLore(" ");
        final ItemBuilder info = new ItemBuilder(Material.PAPER).setTitle("&cWykonane Akcje").addLore("").addLore(ChatUtil.fix("&7Zbanowani: &c" + Main.getInstance().getConfig().getInt("stats.op-protection")));
        inv.setItem(16, info.build());
        inv.setItem(14, none.build());
        inv.setItem(12, none.build());
        inv.setItem(10, none.build());
        return p.openInventory(inv);
    }
}
