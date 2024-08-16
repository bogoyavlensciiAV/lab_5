package commands;

import exceptions.InappropriateArgumentException;

public class Exit extends Command{
    public Exit() {
        super("exit", "exit : завершить программу (без сохранения в файл)");
    }

    @Override
    public void execute(String argument) throws InappropriateArgumentException {
        if (!argument.isEmpty()) {
            throw new InappropriateArgumentException("аргумент должен отсутствовать");
        }
        System.exit(0);
    }
}
