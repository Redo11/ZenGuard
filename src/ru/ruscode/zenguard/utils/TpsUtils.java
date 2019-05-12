package ru.ruscode.zenguard.utils;

public class TpsUtils
        implements Runnable
{
    public static int TICK_COUNT= 0;
    public static long[] TICKS= new long[600];
    public static long LAST_TICK= 0L;

    public static double getTPS()
    {
        return getTPS(100);
    }

    public static double getTPS(int ticks)
    {
        if (TICK_COUNT< ticks) {
            return 20.0D;
        }
        int target = (TICK_COUNT- 1 - ticks) % TICKS.length;
        long elapsed = System.currentTimeMillis() - TICKS[target];

        return ticks / (elapsed / 1000.0D);
    }

    public static long getElapsed(int tickID)
    {
        if (TICK_COUNT- tickID >= TICKS.length)
        {
        }

        long time = TICKS[(tickID % TICKS.length)];
        return System.currentTimeMillis() - time;
    }

    public void run()
    {
        TICKS[(TICK_COUNT% TICKS.length)] = System.currentTimeMillis();

        TICK_COUNT+= 1;
    }
    public static String readableByteCount(final long bytes) {
        if (bytes < 1536L) {
            return String.valueOf(bytes) + " B";
        }
        final int exp = (int)(Math.log((double)bytes) / Math.log(1536.0));
        final String pre = String.valueOf("KMGTPE".charAt(exp - 1));
        return String.format("%.2f %sB", bytes / Math.pow(1024.0, exp), pre);
    }
}
