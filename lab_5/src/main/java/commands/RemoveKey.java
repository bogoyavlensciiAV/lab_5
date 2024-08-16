package commands;

import exceptions.InappropriateArgumentException;
import managers.CollectionManager;
import utilities.FormatCheck;

public class RemoveKey extends Command{
    public RemoveKey() {
        super("remove_key", "remove_key null : удалить элемент из коллекции по его ключу");
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
        CollectionManager.removeByKey(Integer.parseInt(argument));
    }
}
