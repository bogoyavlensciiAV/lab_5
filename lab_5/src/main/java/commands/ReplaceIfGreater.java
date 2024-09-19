package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import managers.CollectionManager;
import models.Dragon;
import utilities.FormatCheck;

public class ReplaceIfGreater extends Command{
    public ReplaceIfGreater() {
        super("replace_if_greater null {element}", "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого");
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
        } else {
            ConsoleApp.commandPrint("Дракон будет обновлён в случае если его имя длиннее");
            Dragon oldDrag = CollectionManager.getDragon(Integer.parseInt(argument));
            Dragon newDrag = ConsoleApp.createDragon();
            if (!newDrag.check()){
                ConsoleApp.commandPrint("Дракон не был обновлён, преждевременное завершение");
            } else if (newDrag.compareTo(oldDrag) < 0){
                ConsoleApp.commandPrint("Дракон не был обновлён, новый дракон меньше");
            } else {
                CollectionManager.addDragon(Integer.valueOf(argument), newDrag);
                ConsoleApp.commandPrint("Дракон был обновлён");
            }
        }
    }
}
