package pl.xthunderek.zenguard.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.xthunderek.zenguard.utils.ChatUtil;
import pl.xthunderek.zenguard.utils.Config;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(ChatUtil.fix(Config.getString("messages.gui-name")))){
            e.setCancelled(true);
            if (e.getSlot() == 12){
                p.getOpenInventory().close();
                p.chat("/zenguard reload");
            }
        }
    }
}
