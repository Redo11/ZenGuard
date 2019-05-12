package ru.ruscode.zenguard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.ruscode.zenguard.commands.ZenGuardCommand;
import ru.ruscode.zenguard.listeners.InventoryClickListener;
import ru.ruscode.zenguard.listeners.OnCommandListener;
import ru.ruscode.zenguard.listeners.PlayerOnJoinEvent;

import java.io.File;

public class Main extends JavaPlugin {
    private static Main instance;

    public void onEnable(){
        final File f = new File("plugins/ZenGuard/playerdata");
        if (!f.exists()) {
            f.mkdir();
        }
        this.getCommand("zenguard").setExecutor(new ZenGuardCommand());
        setInstance(this);
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerOnJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new OnCommandListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }
    public static Main getInstance() {
        return Main.instance;
    }

    private static void setInstance(final Main instance) {
        Main.instance = instance;
    }
}
