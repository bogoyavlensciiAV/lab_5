package commands;
import console.ConsoleApp;
import managers.CollectionManager;
import exceptions.InappropriateArgumentException;
import models.Dragon;
import utilities.FormatCheck;

import java.util.Map;

public class Update extends Command{
    public Update() {
        super("update", "update id {element} : обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        boolean check = false;
        Integer key = null;
        if (argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен присутствовать");
        }
        if (!FormatCheck.isInt(argument)){
            throw new InappropriateArgumentException("аргумент должен быть числом типа Integer");
        }
        for (Map.Entry<Integer,Dragon> entry: CollectionManager.getCollection().entrySet()){
            Dragon value = entry.getValue();
            if (value.getId() == Integer.parseInt(argument)){
                check = true;
                key = entry.getKey();
                break;
            }
        }
        if (!check){
            throw new InappropriateArgumentException("Дракона с данным id нет в коллекции");
        } else {
            Dragon drag = ConsoleApp.createDragon();
            drag.setId(Integer.parseInt(argument));
            if (!drag.check()){
                ConsoleApp.commandPrint("Дракон не был обновлён");
            } else {
                CollectionManager.addDragon(key, drag);
                ConsoleApp.commandPrint("Дракон был обновлён");
            }
        }
    }
}
