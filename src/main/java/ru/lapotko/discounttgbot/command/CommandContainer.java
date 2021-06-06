package ru.lapotko.discounttgbot.command;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lapotko.discounttgbot.service.SendMessageService;

@Component
public class CommandContainer {
    private final ImmutableMap<String, Command> commands;
    private final UnknownCommand unknownCommand;

    @Autowired
    public CommandContainer(SendMessageService sendMessageService) {
        commands = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getName(), new StartCommand(sendMessageService))
                .put(CommandName.NOCOMMAND.getName(), new NoCommand(sendMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command findCommand(String name){
        return commands.getOrDefault(name, unknownCommand);
    }
}
