package ru.lapotko.discounttgbot.builder;

import lombok.Setter;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public final class MessageBuilder {
    @Setter
    private Long chatId;
    private final StringBuilder sb;

    private MessageBuilder() {
        sb = new StringBuilder();
    }

    public static MessageBuilder builder(Long chatId){
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setChatId(chatId);
        return messageBuilder;
    }

    public MessageBuilder line(String text, Object... args){
        sb.append(String.format(text, args));
        return line();
    }

    public MessageBuilder line() {
        sb.append("\n");
        return this;
    }

    public SendMessage build(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(sb.toString());
        return sendMessage;
    }
}
