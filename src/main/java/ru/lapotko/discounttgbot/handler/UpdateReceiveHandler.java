package ru.lapotko.discounttgbot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lapotko.discounttgbot.command.CommandContainer;
import ru.lapotko.discounttgbot.command.CommandName;

@Component
public class UpdateReceiveHandler {
    private final CommandContainer commandContainer;

    @Autowired
    public UpdateReceiveHandler(CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
    }

    public SendMessage handleUpdate(Update update) {
        Message message = update.getMessage();
        if (update.hasMessage() && message.hasText()) {
            String textOfMessage = message.getText();
            if (textOfMessage.startsWith("/")) {
                String commandName = textOfMessage.split(" ")[0].toLowerCase();
                return commandContainer.findCommand(commandName).execute(update);
            }
        }
        return commandContainer.findCommand(CommandName.NOCOMMAND.getName()).execute(update);
    }
}
