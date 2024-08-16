
import console.ConsoleApp;
import managers.CollectionManager;
import managers.FileManager;
import models.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashMap;

import static java.time.ZoneOffset.UTC;

public class App {
    public static void main(String[] args) {
//        Dragon drag = new Dragon(1, "Аня", new Coordinates(11, 244L), ZonedDateTime.of(2005, 5, 11, 0, 0, 0, 0, UTC), 18, 59.8F, DragonType.WATER, DragonCharacter.GOOD, new DragonCave(11.2F, 15.4));
//        Dragon drag2 = new Dragon(2, "Саня", new Coordinates(11, 2L), ZonedDateTime.of(2006, 4, 11, 0, 0, 0, 0, UTC), 18, 59.8F, DragonType.WATER, DragonCharacter.GOOD, new DragonCave(11.2F, 15.4));
//        System.out.println(drag);
//        CollectionManager.addDragon(drag);
//        CollectionManager.addDragon(drag2);
        FileManager fileManager = new FileManager();
        fileManager.readFile();
//        fileManager.writeFile();
        ConsoleApp.interactiveMod();
    }
}