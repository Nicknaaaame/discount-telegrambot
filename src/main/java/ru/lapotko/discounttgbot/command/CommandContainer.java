package ru.lapotko.discounttgbot.command;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandContainer {
    private final ImmutableMap<String, Command> commands;
    private final UnknownCommand unknownCommand;

    @Autowired
    public CommandContainer() {
        commands = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getName(), new StartCommand())
                .put(CommandName.NOCOMMAND.getName(), new NoCommand())
                .build();
        unknownCommand = new UnknownCommand();
    }

    public Command findCommand(String name){
        return commands.getOrDefault(name, unknownCommand);
    }
}
