package ru.lapotko.discounttgbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lapotko.discounttgbot.bot.DiscountTelegramBot;

@Service
public class SendMessageServiceImpl implements SendMessageService {
    @Autowired
    private DiscountTelegramBot bot;

    @Override
    public void sendMessage(Long chatId, String message) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(message);
        bot.execute(sendMessage);
    }
}
