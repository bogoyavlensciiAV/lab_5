package utilities;

import managers.CollectionManager;

public class IdGenerator {
    private static int idCounter = CollectionManager.getMaxId()+1;
    public static Integer nextId() {
        return idCounter++;
    }
}
