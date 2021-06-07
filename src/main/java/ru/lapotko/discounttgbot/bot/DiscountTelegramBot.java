package ru.lapotko.discounttgbot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lapotko.discounttgbot.handler.UpdateReceiveHandler;

@Component
public class DiscountTelegramBot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String botUsername;

    private final UpdateReceiveHandler updateReceiveHandler;

    public DiscountTelegramBot(UpdateReceiveHandler updateReceiveHandler) {
        this.updateReceiveHandler = updateReceiveHandler;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(updateReceiveHandler.handleUpdate(update));
        } catch (TelegramApiException e) {
            //TODO: add logging
            e.printStackTrace();
        }
    }
}
