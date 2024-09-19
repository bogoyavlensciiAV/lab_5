
import console.ConsoleApp;
import managers.FileManager;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        try {
            FileManager.readFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ConsoleApp.interactiveMod();
    }
}