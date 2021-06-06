package ru.lapotko.discounttgbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lapotko.discounttgbot.service.SendMessageService;

public class UnknownCommand implements Command {
    private static final String UNKNOWN_COMMAND_MESSAGE = "Unknown command";

    private final SendMessageService sendMessageService;

    public UnknownCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) throws TelegramApiException {
        sendMessageService.sendMessage(update.getMessage().getChatId(), UNKNOWN_COMMAND_MESSAGE);
    }
}
