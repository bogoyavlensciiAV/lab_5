package commands;

import exceptions.InappropriateArgumentException;
import managers.CollectionManager;

public class Clear extends Command{
    public Clear() {
        super("clear", "clear : очистить коллекцию");
    }

    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        CollectionManager.clearData();
    }
}
