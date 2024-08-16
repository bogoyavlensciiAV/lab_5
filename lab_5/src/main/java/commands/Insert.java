package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import managers.CollectionManager;
import models.Dragon;
import utilities.FormatCheck;

import java.util.HashMap;

public class Insert extends Command{
    public Insert() {
        super("insert", "insert null {element} : добавить новый элемент с заданным ключом");
    }
    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен присутствовать");
        }
        if (!FormatCheck.isInt(argument)) {
            throw new InappropriateArgumentException("аргумент должен быть числом типа Integer");
        }
        if (CollectionManager.hasKey(Integer.parseInt(argument))){
            throw new InappropriateArgumentException("Дракон с данным ключом уже присутствует в коллекции");
        } else {
            Dragon drag = ConsoleApp.createDragon();
            if (!drag.check()){
                ConsoleApp.commandPrint("Дракон не был добавлен в коллекцию");
            } else {
                CollectionManager.addDragon(Integer.valueOf(argument), drag);
                ConsoleApp.commandPrint("Дракон был добавлен в коллекцию");
            }
        }
    }
}
