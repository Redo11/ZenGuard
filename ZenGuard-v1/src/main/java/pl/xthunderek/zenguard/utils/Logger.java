package pl.xthunderek.zenguard.utils;

import pl.xthunderek.zenguard.enums.LogType;

public class Logger {
    public static void log(String s, LogType logType){
        System.out.println("[ZenGuard] " + logType.getPrefix() + s);
    }
}
