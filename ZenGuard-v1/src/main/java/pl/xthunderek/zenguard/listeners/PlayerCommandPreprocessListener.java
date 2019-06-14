package pl.xthunderek.zenguard.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.xthunderek.zenguard.utils.ChatUtil;
import pl.xthunderek.zenguard.utils.Config;

public class PlayerCommandPreprocessListener implements Listener {
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if (Config.getBoolean("command-protection.enabled")) {
            if (Config.isCommandProtected(e.getMessage())) {
                Config.set("stats.command-protection", Config.getInt("stats.command-protection") + 1);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Config.getString("command-protection.command").replace("%player%", p.getName()));
                ChatUtil.broadcast(Config.getString("command-protection.broadcast"));
            }
        }
        if (p.isOp()){
            if (Config.getConfig().getBoolean("op-protection.enabled")){
                if (!Config.isOnOpProtection(p.getName())){
                    Config.set("stats.op-protection", Config.getInt("stats.command-protection") + 1);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Config.getString("op-protection.command").replace("%player%", p.getName()));
                    ChatUtil.broadcast(Config.getString("op-protection.broadcase").replace("%player%", p.getName()));
                }
            }
        }
    }
}