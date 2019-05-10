package ru.ruscode.zenguard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.ruscode.zenguard.commands.ZenGuardCommand;
import ru.ruscode.zenguard.listeners.InventoryClickListener;
import ru.ruscode.zenguard.listeners.OnCommandListener;

public class Main extends JavaPlugin {
    private static Main instance;

    public void onEnable(){
        this.getCommand("zenguard").setExecutor(new ZenGuardCommand());
        setInstance(this);
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new OnCommandListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public static Main getInstance() {
        return Main.instance;
    }

    public static void setInstance(final Main instance) {
        Main.instance = instance;
    }
}
