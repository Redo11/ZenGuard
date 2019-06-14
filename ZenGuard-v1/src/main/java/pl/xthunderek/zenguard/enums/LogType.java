package pl.xthunderek.zenguard.enums;

public enum LogType {
    INFO("(INFO) "),
    WARN("(WARN) "),
    ERROR("(ERROR) ");

    private final String prefix;

    LogType(final String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return this.prefix;
    }
}
