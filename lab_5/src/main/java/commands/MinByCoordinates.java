package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import exceptions.NullCollectionException;
import managers.CollectionManager;
import models.Dragon;
import utilities.MinCoordinatesComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MinByCoordinates extends Command{
    public MinByCoordinates() {
        super("min_by_coordinates", "min_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является минимальным");
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
        List<Dragon> DragonByCoordinates = new ArrayList<>(collection.values());//запихнуть в менеджер
        Collections.sort(DragonByCoordinates, new MinCoordinatesComparator());//запихнуть в менеджер
        ConsoleApp.commandPrint(String.valueOf(DragonByCoordinates.get(0)));//запихнуть в менеджер
    }
}

