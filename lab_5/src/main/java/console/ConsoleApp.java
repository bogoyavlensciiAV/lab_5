package console;

import commands.Command;
import exceptions.InappropriateArgumentException;
import exceptions.NullCollectionException;
import models.*;
import utilities.FormatCheck;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static commands.Command.commandMap;

public class ConsoleApp {
    public static Scanner reader = new Scanner(System.in);
    public static void commandPrint(String string) {
        System.out.println(string);
    }
    public static Dragon createDragon(){
        Dragon drag = new Dragon();
        int x;
        float depth;
        System.out.println("Создание дракона (для завершения введите exit)");
        while (true) {
            System.out.print("Введите имя дракона: ");
            String input  = reader.nextLine();
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
            System.out.print("Введите координатy x: ");
            String input  = reader.nextLine().trim();
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
            System.out.print("Введите координатy y: ");
            String input  = reader.nextLine().trim();
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
            System.out.print("Введите возраст дракона: ");
            String input  = reader.nextLine().trim();
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
            System.out.print("Введите вec дракона: ");
            String input  = reader.nextLine().trim();
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
            System.out.print("Введите тип дракона(число): \n"+ Arrays.toString(DragonType.values())+"\n");
            String input  = reader.nextLine().trim();
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
            System.out.print("Введите характер дракона(число): \n"+ Arrays.toString(DragonCharacter.values())+"\n");
            String input  = reader.nextLine().trim();
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
            System.out.print("Введите глубину пещеры дракона: ");
            String input  = reader.nextLine().trim();
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
            System.out.print("Введите кол-во сокровищ в пещере: ");
            String input  = reader.nextLine().trim();
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
        String[] commandHistory = new String[6];
        System.out.println("Введите help для получения инструкции");
        while (true) {
            try {
                System.out.print(">");
                String input  = reader.nextLine();
                if (Objects.isNull(input)){
                    System.exit(0);
                }
                String[] str = input.replaceAll(" +", " ").split(" "); //если вдруг понадобиться чтобы работало и при пробелах в начале, то trim()
                try {
                    String argument = str.length > 1 ? str[1] : "";
                    commandMap.get(str[0]).execute(argument);
                    commandHistory[0] = str[0];
                    for (int i = 0; i < 5; i++){
                        commandHistory[i+1] = Command.commandHistory[i];
                    }
                    for (int i = 0; i < 6; i++){
                        Command.commandHistory[i] = commandHistory[i];
                    }
                    System.out.println("Команда успешно выполнена");
                } catch (InappropriateArgumentException exc) {
                    System.out.println("Неверный аргумент: "+ exc.getMessage());
                } catch (NullPointerException exc) {
                    System.out.println("Такой команды нет");
                } catch (NullCollectionException exc){
                    System.out.println(exc.getMessage());
                }
            } catch (Exception exc) {
                System.out.println(exc.toString());
                System.out.println("Непредвиденная ошибка");
            }
        }
    }
}
