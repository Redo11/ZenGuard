package ru.ruscode.zenguard.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ru.ruscode.zenguard.utils.ChatUtil;
import ru.ruscode.zenguard.utils.ConfigUtils;

public class OnCommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if (ConfigUtils.getBoolean("command-protection.enabled")) {
            if (ConfigUtils.isCommandProtected(e.getMessage())) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ConfigUtils.getString("command-protection.command").replace("%player%", p.getName()));
                ChatUtil.broadcast(ConfigUtils.getString("command-protection.broadcast"));
            }
        }
        if (p.isOp()){
            if (ConfigUtils.getConfig().getBoolean("op-protection.enabled")){
                if (!ConfigUtils.isOnOpProtection(p.getName())){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ConfigUtils.getString("op-protection.command").replace("%player%", p.getName()));
                    ChatUtil.broadcast(ConfigUtils.getString("op-protection.broadcase").replace("%player%", p.getName()));
                }
            }
        }
    }
}