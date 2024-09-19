package console;

import commands.Command;
import exceptions.InappropriateArgumentException;
import exceptions.NullCollectionException;
import exceptions.RecurtionScriptException;
import managers.FileManager;
import models.*;
import utilities.FormatCheck;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static commands.Command.commandMap;

public class ConsoleApp {
    public static Scanner reader = new Scanner(System.in);
    public static Scanner script;
    public static boolean consoleMode;
    public static int depthRecursion = 0;
    public static void commandAsk(String string) {
        if (!consoleMode){
            System.out.println(string);
        }
    }
    public static void commandPrint(String string) {System.out.println(string);}
    public static Scanner getScanner(){
        if (consoleMode){
            return script;
        } else {
            return reader;
        }
    }

    public static Dragon createDragon(){
        Dragon drag = new Dragon();
        Scanner scanner = getScanner();
        int x;
        float depth;
        commandAsk("Создание дракона (для завершения введите exit)");
        while (true) {
            commandAsk("Введите имя дракона: ");
            String input  = scanner.nextLine();
            if (input.equals("exit")){
                return drag;
            }
            if (input.trim().isEmpty()){
                System.out.println("Имя должно присутствовать!");
                continue;
            }
            drag.setName(input);
            break;
        }
        while (true) {
            commandAsk("Введите координатy x: ");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Координата x должны присутствовать!");
                continue;
            }
            if (!FormatCheck.isInt(input)){
                System.out.println("Неверный тип: x должен быть типа int");
                continue;
            }
            if (!Coordinates.checkX(Integer.parseInt(input))){
                System.out.println("x должен быть не больше 492");
                continue;
            }
            x = Integer.parseInt(input);
            break;
        }
        while (true) {
            commandAsk("Введите координатy y: ");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Координата y должны присутствовать!");
                continue;
            }
            if (!FormatCheck.isLong(input)){
                System.out.println("Неверный тип: y должен быть типа Long");
                continue;
            }
            Coordinates crd = new Coordinates(x,Long.parseLong(input));
            drag.setCoordinates(crd);
            break;
        }
        while (true) {
            commandAsk("Введите возраст дракона: ");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Возраст должен присутствовать!");
                continue;
            }
            if (!FormatCheck.isInt(input)){
                System.out.println("Неверный тип: возраст должен быть типа Integer");
                continue;
            }
            int age = Integer.parseInt(input);
            if (age <= 0){
                System.out.println("Возраст должен быть больше 0");
                continue;
            }
            drag.setAge(age);
            break;
        }
        while (true) {
            commandAsk("Введите вec дракона: ");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Вес должен присутствовать!");
                continue;
            }
            if (!FormatCheck.isFloat(input)){
                System.out.println("Неверный тип: вec должен быть типа float!");
                continue;
            }
            drag.setWeight(Float.parseFloat(input));
            break;
        }
        while (true) {
            commandAsk("Введите тип дракона(число): \n"+ Arrays.toString(DragonType.values())+"\n");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Тип должен присутствовать!");
                continue;
            }
            DragonType type = null;
            try {
                type = DragonType.values()[Integer.parseInt(input)];
            } catch (Exception exp) {
                System.out.println("Нужно ввести число из представленного списка!");
                continue;
            }
            drag.setType(type);
            break;
        }
        while (true) {
            commandAsk("Введите характер дракона(число): \n"+ Arrays.toString(DragonCharacter.values())+"\n");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Характер должен присутствовать!");
                continue;
            }
            DragonCharacter chr = null;
            try {
                chr = DragonCharacter.values()[Integer.parseInt(input)];
            } catch (Exception exp) {
                System.out.println("Нужно ввести число из представленного списка!");
                continue;
            }
            drag.setCharacter(chr);
            break;
        }
        while (true) {
            commandAsk("Введите глубину пещеры дракона: ");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Глубина пещеры должны присутствовать!");
                continue;
            }
            if (!FormatCheck.isFloat(input)){
                System.out.println("Неверный тип: глубина пещеры должена быть типа float");
                continue;
            }
            depth = Float.parseFloat(input);
            break;
        }
        while (true) {
            commandAsk("Введите кол-во сокровищ в пещере: ");
            String input  = scanner.nextLine().trim();
            if (input.equals("exit")){
                return drag;
            }
            if (input.isEmpty()){
                System.out.println("Кол-во сокровищ должно присутствовать!");
                continue;
            }
            if (!FormatCheck.isDouble(input)){
                System.out.println("Неверный тип: кол-во сокровищ должно быть типа Double");
                continue;
            }
            DragonCave cave = new DragonCave(depth,Double.parseDouble(input));
            drag.setCave(cave);
            break;
        }
        return drag;
    }
    public static void interactiveMod() {
        System.out.println("Введите help для получения инструкции");
        while (true) {
            try {
                System.out.print(">");
                String input  = reader.nextLine();
                if (Objects.isNull(input)){
                    System.exit(0);
                }
                String[] str = input.trim().replaceAll(" +", " ").split(" "); //если вдруг понадобиться чтобы работало и при пробелах в начале, то trim()
                try {
                    String argument = str.length > 1 ? str[1] : "";
                    commandMap.get(str[0]).execute(argument);
                    consoleMode = false;
                    if (Command.commandHistory.size() == 6) {
                        Command.commandHistory.remove();
                    }
                    Command.commandHistory.add(str[0]);
                    System.out.println("Команда успешно выполнена");
                } catch (InappropriateArgumentException exc) {
                    System.out.println("Неверный аргумент: "+ exc.getMessage());
                } catch (NullPointerException exc) {
                    System.out.println("Такой команды нет");
                } catch (NullCollectionException exc){
                    System.out.println(exc.getMessage());
                }
            } catch (Exception exc) {
                System.out.println("Непредвиденная ошибка: "+ exc.getMessage());
            }
        }
    }
    public static void scriptMod(String path){
        consoleMode = true;
        script = FileManager.readScript(path);
        
        while (script.hasNext()) {
            try {
                String input  = script.nextLine();
                if (Objects.isNull(input)){
                    System.exit(0);
                }
                String[] str = input.trim().replaceAll(" +", " ").split(" "); //если вдруг понадобиться чтобы работало и при пробелах в начале, то trim()
                try {
                    String argument = str.length > 1 ? str[1] : "";
                    if (str[0].equals("execute_script")){
                        depthRecursion+=1;
                    }
                    if (depthRecursion >= 3){
                        throw new RecurtionScriptException("Превышена глубина рекурсии!");
                    }
                    commandMap.get(str[0]).execute(argument);
                    if (Command.commandHistory.size() == 6) {
                        Command.commandHistory.remove();
                    }
                    Command.commandHistory.add(str[0]);
                    System.out.println("Команда успешно выполнена");
                } catch (InappropriateArgumentException exc) {
                    System.out.println("Неверный аргумент: "+ exc.getMessage());
                } catch (NullPointerException exc) {
                    System.out.println("Такой команды нет");
                } catch (NullCollectionException exc){
                    System.out.println(exc.getMessage());
                } catch (RecurtionScriptException exc){
                    System.out.println(exc.getMessage());
                }
            } catch (Exception exc) {
                exc.printStackTrace();
                System.out.println("Непредвиденная ошибка");
            }
        }
    }
}
