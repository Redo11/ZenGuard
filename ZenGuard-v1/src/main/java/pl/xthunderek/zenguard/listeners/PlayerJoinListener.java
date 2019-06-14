package pl.xthunderek.zenguard.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.xthunderek.zenguard.basic.ZenGuard;
import pl.xthunderek.zenguard.utils.ChatUtil;
import pl.xthunderek.zenguard.utils.Config;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (Config.getBoolean("player-log.enabled")) {
            Player p = e.getPlayer();
            String p1 = p.getName();
            if (Config.getBoolean("join-message")){
                p.sendMessage(ChatUtil.fix(Config.getString("messages.join-message").replace("%ver%", ZenGuard.getInstance().getDescription().getVersion())));
            }
            if (Config.getBoolean("player-log.save-ip")) {
                Config.set("data." + p1 + ".ip-adress", e.getPlayer().getAddress().toString());
            }
        }
    }
}