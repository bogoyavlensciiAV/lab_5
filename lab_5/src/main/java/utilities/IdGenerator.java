package utilities;

public class IdGenerator {
    private static int idCounter;
    public static Integer nextId() {
        return idCounter++;
    }
}
