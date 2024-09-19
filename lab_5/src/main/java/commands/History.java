package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import managers.CollectionManager;

import java.util.HashMap;

public class History extends Command{
    public History() {
        super("history", "history : вывести последние 6 команд (без их аргументов)");
    }
    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        Command.commandHistory.forEach(System.out::println);
    }
}
