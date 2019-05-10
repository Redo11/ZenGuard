package ru.ruscode.zenguard.listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import ru.ruscode.zenguard.Main;
import ru.ruscode.zenguard.utils.ChatUtil;
import ru.ruscode.zenguard.utils.ConfigUtils;

public class OnCommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("op-protection.enabled")){
            if (p.isOp()){
                if (!ConfigUtils.isOnOpProtection(p.getName())){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("op-protection.command"));
                    ChatUtil.broadcast(FileConfiguration.createPath(Main.getInstance().getConfig(), "op-protection.broadcast"));
                }
            }
        }
    }
}
