package commands;

import java.util.HashMap;
import exceptions.InappropriateArgumentException;
import exceptions.NullCollectionException;

public abstract class Command {
    protected String name;
    protected String description;

    public static HashMap<String, Command> commandMap = new HashMap<>(); //мапа для всех команд (имя, объект Command)
    public static String[] commandHistory = new String[6];
    static {
        commandMap.put("help",  new Help());
        commandMap.put("show",  new Show());
        commandMap.put("info",  new Info());
        commandMap.put("exit", new Exit());
        commandMap.put("clear", new Clear());
        commandMap.put("remove_key", new RemoveKey());
        commandMap.put("save", new Save());
        commandMap.put("min_by_coordinates", new MinByCoordinates());
        commandMap.put("max_by_age", new MaxByAge());
        commandMap.put("insert", new Insert());
        commandMap.put("update", new Update());
        commandMap.put("history", new History());
        commandMap.put("print_ascending", new PrintAscending());
        commandMap.put("remove_greater", new RemoveGreater());
    }

    public abstract void execute(String argument) throws InappropriateArgumentException, NullCollectionException;


    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return this.name;
    }
}
