package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import managers.FileManager;

public class Save extends Command{
    public Save() {
        super("save", "save : сохранить коллекцию в файл");
    }
    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        FileManager fileManager = new FileManager();
        fileManager.writeFile();
    }
}