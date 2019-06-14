package pl.xthunderek.zenguard.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChatUtil {

    public static String fix(String text){
        return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»"));
    }
    public static void broadcast(String text){
        Bukkit.broadcastMessage(ChatUtil.fix(text));
    }

    public static String percentFormat(final double siema) {
        return String.format("%.2f", siema);
    }

    public static String getTime(){
        final Calendar cal = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat(Config.getString("general.date-format"));
        final String time = sdf.format(cal.getTime());
        return time;
    }
}
