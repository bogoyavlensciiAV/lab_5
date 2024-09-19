package commands;

import console.ConsoleApp;
import exceptions.InappropriateArgumentException;
import managers.CollectionManager;
import models.Dragon;
import utilities.FormatCheck;

public class ExecuteScript extends Command{
    public ExecuteScript() {
        super("execute_script file_name", "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }
    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен присутствовать");
        }
        ConsoleApp.scriptMod(argument);
        ConsoleApp.depthRecursion = 0;
    }
}