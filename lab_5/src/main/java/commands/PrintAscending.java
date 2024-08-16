package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import managers.CollectionManager;
import models.Dragon;

import java.util.*;

import static managers.CollectionManager.getCollection;

public class PrintAscending extends Command{
    public PrintAscending() {
        super("print_ascending", "print_ascending : вывести элементы коллекции в порядке возрастания");
    }

    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        HashMap<Integer, Dragon> sortedCollection = CollectionManager.getSortedCollection();



        for (Map.Entry<Integer,Dragon> entry : sortedCollection.entrySet()) {
            Integer key = entry.getKey();
            Dragon dragon = entry.getValue();
            ConsoleApp.commandPrint("key: "+key+"; "+ dragon.toString());
        }
    }
}