package ru.ruscode.zenguard.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ChatUtil {
    public static String fix(String text){
        return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»"));
    }
    public static void broadcast(String text){
        Bukkit.broadcastMessage(ChatUtil.fix(text));
    }
}
