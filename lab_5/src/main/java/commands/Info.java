package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import managers.CollectionManager;

import java.util.HashMap;

public class Info extends Command{
    public Info() {
        super("info", "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)");
    }
    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        ConsoleApp.commandPrint("Тип коллекции: "+ HashMap.class.getName()+"\nДата инициализации: "+ CollectionManager.getInicializationDate()+"\nКоличество элементов: "+CollectionManager.getCollection().size());
    }
}
