package ru.lapotko.discounttgbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lapotko.discounttgbot.service.SendMessageService;

public class StartCommand extends AbstractCommand {
    private static final String START_COMMAND_MESSAGE = "You have started the chat, %s";

    protected StartCommand(SendMessageService sendMessageService) {
        super(sendMessageService);
    }

    @Override
    public void execute(Update update) throws TelegramApiException {
        Long chatId = update.getMessage().getChatId();
        String username = update.getMessage().getFrom().getUserName();
        String resultMessage = String.format(START_COMMAND_MESSAGE, username);
        sendMessageService.sendMessage(chatId, resultMessage);
    }
}
