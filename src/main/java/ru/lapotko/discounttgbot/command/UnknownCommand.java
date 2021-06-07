package ru.lapotko.discounttgbot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lapotko.discounttgbot.builder.MessageBuilder;

public class UnknownCommand extends AbstractCommand {
    private static final String UNKNOWN_COMMAND_MESSAGE = "Unknown command";

    @Override
    public SendMessage execute(Update update) {
        return MessageBuilder.builder(update.getMessage().getChatId())
                .line(UNKNOWN_COMMAND_MESSAGE)
                .build();
    }
}
