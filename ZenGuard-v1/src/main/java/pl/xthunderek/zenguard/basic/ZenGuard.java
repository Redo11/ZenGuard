package pl.xthunderek.zenguard.basic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.xthunderek.zenguard.commands.ZenGuardCommand;
import pl.xthunderek.zenguard.enums.LogType;
import pl.xthunderek.zenguard.listeners.PlayerCommandPreprocessListener;
import pl.xthunderek.zenguard.listeners.InventoryClickListener;
import pl.xthunderek.zenguard.listeners.PlayerJoinListener;
import pl.xthunderek.zenguard.utils.AuthMeHook;
import pl.xthunderek.zenguard.utils.Config;
import pl.xthunderek.zenguard.utils.Logger;

public class ZenGuard extends JavaPlugin {
    private static ZenGuard instance;
    private AuthMeHook authMeHook;
    private static boolean authmehook;

    public void onEnable(){
        if (Bukkit.getPluginManager().isPluginEnabled("AuthMe")) {
            if (Config.getBoolean("hooks.authme")) {
                authMeHook = new AuthMeHook();
                registerAuthMeComponents();
                authmehook = true;
            } else{
                Logger.log("AuthMe detected, but hook is disabled in config.yml!", LogType.WARN);
            }
        } else{
            Logger.log("You don't have AuthMe plugin installed/enabled! AuthMe hook is not enabled.", LogType.ERROR);
            authmehook = false;
        }
        this.getCommand("zenguard").setExecutor(new ZenGuardCommand());
        setInstance(this);
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocessListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Logger.log("Plugin succesfully loaded!", LogType.INFO);
    }

    public void registerAuthMeComponents() {
        Logger.log("AuthMe plugin deteced! Hooking...", LogType.INFO);
        authMeHook.initializeAuthMeHook();
    }

    /**
     * Deactivates the AuthMe hook. Call when AuthMe has been disabled.
     */
    public void removeAuthMeHook() {
        Logger.log("AuthMe hook disabled!", LogType.WARN);
        authMeHook.removeAuthMeHook();
    }

    public static ZenGuard getInstance() {
        return ZenGuard.instance;
    }

    private static void setInstance(final ZenGuard instance) {
        ZenGuard.instance = instance;
    }

    public static boolean getAuthmeHook(){
        return ZenGuard.authmehook;
    }
}
