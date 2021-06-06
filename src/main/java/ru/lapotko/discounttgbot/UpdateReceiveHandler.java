package ru.lapotko.discounttgbot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UpdateReceiveHandler {
    public SendMessage handleUpdate(Update update) {
        SendMessage sendMessage = new SendMessage();
        return sendMessage;
    }
}
