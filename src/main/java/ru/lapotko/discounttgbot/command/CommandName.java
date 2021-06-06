package ru.lapotko.discounttgbot.command;

public enum CommandName {
    START("/start"),
    NOCOMMAND("nocommand");
    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
