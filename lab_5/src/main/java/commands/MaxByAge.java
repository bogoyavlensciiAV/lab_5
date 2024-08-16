package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import exceptions.NullCollectionException;
import managers.CollectionManager;
import models.Dragon;
import utilities.MaxAgeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaxByAge extends Command{
    public MaxByAge() {
        super("max_by_age", "max_by_age : вывести любой объект из коллекции, значение поля age которого является максимальным");
    }
    @Override
    public void execute(String argument) throws InappropriateArgumentException, NullCollectionException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        HashMap<Integer, Dragon> collection = CollectionManager.getCollection();
        if (collection.isEmpty()){
            throw new NullCollectionException("Коллекция пустая");
        }
        List<Dragon> DragonByAge = new ArrayList<>(collection.values());
        Collections.sort(DragonByAge, new MaxAgeComparator());
        ConsoleApp.commandPrint(String.valueOf(DragonByAge.getFirst()));
    }
}

