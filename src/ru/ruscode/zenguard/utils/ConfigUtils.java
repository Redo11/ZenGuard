package ru.ruscode.zenguard.utils;

import org.bukkit.configuration.file.FileConfiguration;
import ru.ruscode.zenguard.Main;
import java.util.List;

public class ConfigUtils {


    public static boolean isOnOpProtection(String p){
        List<String> ConfigList = getConfig().getStringList("op-protection.list");
        return ConfigList.contains(p);
    }
    public static boolean isCommandProtected(String cmd){
        List<String> ConfigList = getConfig().getStringList("command-protection.list");
        return ConfigList.contains(cmd);
    }
    public static FileConfiguration getConfig(){
        return Main.getInstance().getConfig();
    }
    public static String getString(String string){
        return getConfig().getString(string);
    }
    public static boolean getBoolean(String string){
        return getConfig().getBoolean(string);
    }
    public static void set(String section, String value){
        getConfig().set(section, value);
        Main.getInstance().saveConfig();
    }
}
