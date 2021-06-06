package ru.lapotko.discounttgbot.command;

import ru.lapotko.discounttgbot.service.SendMessageService;

public abstract class AbstractCommand implements Command {
    protected final SendMessageService sendMessageService;

    protected AbstractCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }
}
