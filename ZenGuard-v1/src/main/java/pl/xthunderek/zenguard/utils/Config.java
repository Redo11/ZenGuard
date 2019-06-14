package pl.xthunderek.zenguard.utils;

import org.bukkit.configuration.file.FileConfiguration;
import pl.xthunderek.zenguard.basic.ZenGuard;

import java.util.List;

public class Config {

    public static boolean isOnOpProtection(String p){
        List<String> ConfigList = getConfig().getStringList("op-protection.list");
        return ConfigList.contains(p);
    }
    public static boolean isCommandProtected(String cmd){
        List<String> ConfigList = getConfig().getStringList("command-protection.list");
        return ConfigList.contains(cmd);
    }
    public static FileConfiguration getConfig(){
        return ZenGuard.getInstance().getConfig();
    }
    public static String getString(String string){
        return getConfig().getString(string);
    }
    public static int getInt(String string){
        return getConfig().getInt(string);
    }
    public static boolean getBoolean(String string){
        return getConfig().getBoolean(string);
    }
    public static void set(String section, String value){
        getConfig().set(section, value);
        save();
    }
    public static void set(String section, int value){
        getConfig().set(section, value);
        save();
    }
    public static void save(){
        ZenGuard.getInstance().saveConfig();
    }
}
