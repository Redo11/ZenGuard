package ru.ruscode.zenguard.utils;

import org.bukkit.entity.Player;
import ru.ruscode.zenguard.Main;

import java.util.List;

public class ConfigUtils {
    //Todo, saving config fields to variables.
    public static boolean isOnOpProtection(String p){
        List<String> ConfigList = Main.getInstance().getConfig().getStringList("op-protection.list");
        if (ConfigList.contains(p)){
            return true;
        }
        else {
            return false;
        }
    }
}
