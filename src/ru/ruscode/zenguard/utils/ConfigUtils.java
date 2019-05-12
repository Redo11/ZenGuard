package ru.ruscode.zenguard.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.ruscode.zenguard.Main;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigUtils {
    public static FileConfiguration getPlayerConfig(String player){
        File customYml = new File("plugins/ZenGuard/playerdata/" + player + ".yml");
        FileConfiguration f = YamlConfiguration.loadConfiguration(customYml);
        return YamlConfiguration.loadConfiguration(customYml);
    }
    public static void saveYml(FileConfiguration ymlConfig, File ymlFile) {
        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Todo, saving config fields to variables. (Maybe not)
    public static boolean isOnOpProtection(String p){
        List<String> ConfigList = getConfig().getStringList("op-protection.list");
        return ConfigList.contains(p);
    }
    public static boolean isCommandExcluded(String p){
        List<String> ConfigList = getConfig().getStringList("player-log.excluded-commands");
        return ConfigList.contains(p);
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
}
