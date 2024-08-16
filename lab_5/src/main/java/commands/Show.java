package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import models.Dragon;

import java.util.HashMap;
import java.util.Map;

import static managers.CollectionManager.getCollection;

public class Show extends Command{
    public Show() {
        super("show", "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        HashMap<Integer, Dragon> collection = getCollection();
        for (Map.Entry<Integer,Dragon> entry: collection.entrySet()) {
            Integer key = entry.getKey();
            Dragon dragon = entry.getValue();
            ConsoleApp.commandPrint("key: "+key+"; "+ dragon.toString());
        }
    }
}
