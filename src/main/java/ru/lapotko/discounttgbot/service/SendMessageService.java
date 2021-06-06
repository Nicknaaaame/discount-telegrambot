package ru.lapotko.discounttgbot.service;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface SendMessageService {
    void sendMessage(Long chatId, String message) throws TelegramApiException;
}
