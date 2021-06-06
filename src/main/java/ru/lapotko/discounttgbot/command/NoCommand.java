package ru.lapotko.discounttgbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lapotko.discounttgbot.service.SendMessageService;

public class NoCommand extends AbstractCommand {
    private static final String NO_COMMAND_MESSAGE = "Start your command with '/'";

    protected NoCommand(SendMessageService sendMessageService) {
        super(sendMessageService);
    }

    @Override
    public void execute(Update update) throws TelegramApiException {
        sendMessageService.sendMessage(update.getMessage().getChatId(), NO_COMMAND_MESSAGE);
    }
}
