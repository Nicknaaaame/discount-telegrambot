package ru.lapotko.discounttgbot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lapotko.discounttgbot.builder.MessageBuilder;

public class StartCommand extends AbstractCommand {
    private static final String START_COMMAND_MESSAGE = "You have started the chat, %s";

    @Override
    public SendMessage execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        String username = update.getMessage().getFrom().getUserName();
        return MessageBuilder.builder(chatId)
                .line(START_COMMAND_MESSAGE, username)
                .build();
    }
}
