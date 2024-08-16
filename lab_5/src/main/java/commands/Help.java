package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;

public class Help extends Command{
    public Help() {
        super("help", "help : вывести справку по доступным командам");
    }

    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        //пробегаем все команды из коллекции и выводим их описание
        for (String i : Command.commandMap.keySet()) {
            ConsoleApp.commandPrint(Command.commandMap.get(i).getDescription());
        }
    }
}
