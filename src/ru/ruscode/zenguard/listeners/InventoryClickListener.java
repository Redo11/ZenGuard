package ru.ruscode.zenguard.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import ru.ruscode.zenguard.utils.ConfigUtils;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getName().equals(ConfigUtils.getString("messages.gui-name"))){
            e.setCancelled(true);
        }
    }
}
