package ru.lapotko.discounttgbot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lapotko.discounttgbot.command.CommandContainer;
import ru.lapotko.discounttgbot.command.CommandName;

@Component
public class DiscountTelegramBot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String botUsername;

    private final CommandContainer commandContainer;

    public DiscountTelegramBot(@Lazy CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
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

        Message message = update.getMessage();
        if (update.hasMessage() && message.hasText()) {
            String textOfMessage = message.getText();
            try {
                if (textOfMessage.startsWith("/")) {
                    String commandName = textOfMessage.split(" ")[0].toLowerCase();
                    commandContainer.findCommand(commandName).execute(update);
                } else {
                    commandContainer.findCommand(CommandName.NOCOMMAND.getName()).execute(update);
                }
            } catch (TelegramApiException e) {
                //TODO: add logging
                e.printStackTrace();
            }
        }
    }
}
