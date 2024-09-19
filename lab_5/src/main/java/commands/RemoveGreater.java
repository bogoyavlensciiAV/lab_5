package commands;

import exceptions.InappropriateArgumentException;
import managers.CollectionManager;
import models.Dragon;
import utilities.FormatCheck;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class RemoveGreater extends Command{
    public RemoveGreater() {
        super("remove_greater {element}", "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный (нужно ввести ключ)");
    }

    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен присутствовать");
        }
        if (!FormatCheck.isInt(argument)){
            throw new InappropriateArgumentException("аргумент должен быть числом");
        }
        if (!CollectionManager.getCollection().containsKey(Integer.parseInt(argument))){
            throw new InappropriateArgumentException("данного ключа нет в коллекции");
        }

    }
}