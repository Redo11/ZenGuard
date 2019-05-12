package ru.ruscode.zenguard.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.ruscode.zenguard.Main;
import ru.ruscode.zenguard.utils.ChatUtil;
import ru.ruscode.zenguard.utils.ConfigUtils;

import java.io.File;
import java.io.IOException;

public class PlayerOnJoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (ConfigUtils.getBoolean("player-log.enabled")) {
            Player p = e.getPlayer();
            String p1 = p.getName();
            final File f = new File("plugins/ZenGuard/playerdata/" + p1 + ".yml");
            if (!f.exists()) {
                try {
                    f.createNewFile();
                    File customYml = new File("plugins/ZenGuard/playerdata/" + p1 + ".yml");
                    FileConfiguration customConfig = YamlConfiguration.loadConfiguration(customYml);
                    ConfigUtils.saveYml(customConfig, customYml);
                } catch (IOException e1) {
                    e1.getCause();
                }
            }
            ConfigUtils.getPlayerConfig(p1).set("name", e.getPlayer().getName());
            if (ConfigUtils.getBoolean("player-log.save-ip")) {
                ConfigUtils.getPlayerConfig(p1).set("ip-adress", e.getPlayer().getAddress());
            }
            if (ConfigUtils.getBoolean("player-log.event-log")) {
                ConfigUtils.getPlayerConfig(p1).set("event-log", ConfigUtils.getPlayerConfig(p1).getStringList("event-log").add("[" + ChatUtil.getTime() + "] " + ConfigUtils.getPlayerConfig(p1).getString("player-log.log-messages.join")));
            }
            File customYml = new File("plugins/ZenGuard/playerdata/" + p1 + ".yml");
            FileConfiguration customConfig = YamlConfiguration.loadConfiguration(customYml);
            ConfigUtils.saveYml(customConfig, customYml);
        }
    }
}
