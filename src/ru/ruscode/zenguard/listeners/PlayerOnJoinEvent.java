package ru.ruscode.zenguard.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.ruscode.zenguard.Main;
import ru.ruscode.zenguard.utils.ChatUtil;
import ru.ruscode.zenguard.utils.ConfigUtils;

public class PlayerOnJoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (ConfigUtils.getBoolean("player-log.enabled")) {
            Player p = e.getPlayer();
            String p1 = p.getName();
            if (ConfigUtils.getBoolean("join-message")){
                p.sendMessage(ChatUtil.fix(ConfigUtils.getString("messages.join-message").replace("%ver%", Main.getInstance().getDescription().getVersion())));
            }
            if (ConfigUtils.getBoolean("player-log.save-ip")) {
                System.out.println("[ZenGuard Debug] Saving IP: " + p1);
                ConfigUtils.set("data." + p1 + ".ip-adress", e.getPlayer().getAddress().toString());
            }
        }
    }
}