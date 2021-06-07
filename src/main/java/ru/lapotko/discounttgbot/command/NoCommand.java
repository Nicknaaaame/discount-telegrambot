package ru.lapotko.discounttgbot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lapotko.discounttgbot.builder.MessageBuilder;

public class NoCommand extends AbstractCommand {
    private static final String NO_COMMAND_MESSAGE = "Start your command with '/'";


    @Override
    public SendMessage execute(Update update) {
        return MessageBuilder.builder(update.getMessage().getChatId())
                .line(NO_COMMAND_MESSAGE)
                .build();
    }
}
