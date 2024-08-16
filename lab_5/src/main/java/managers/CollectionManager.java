package managers;

import models.Dragon;

import java.time.LocalDate;
import java.util.*;

public class CollectionManager {
    private static LocalDate inicializationDate = LocalDate.now();
    private static HashMap<Integer, Dragon> collection = new HashMap<>();

    public static void setInicializationDate(){
        inicializationDate = LocalDate.now();
    }
    public static LocalDate getInicializationDate(){
        return inicializationDate;
    }
    //добавить дракона
    public static void addDragon(Integer key, Dragon dragon) {
        collection.put(key, dragon);
        inicializationDate = LocalDate.now();
    }
    //проверить на наличие ключа
    public static boolean hasKey(Integer key){
        return collection.containsKey(key);
    }
    //удалить коллекцию
    public static void clearData() {
        collection.clear();
        inicializationDate = LocalDate.now();
    }
    //вызов коллекции
    public static HashMap<Integer, Dragon> getCollection() {
        inicializationDate = LocalDate.now();
        return collection;
    }
    public static void setCollection(HashMap<Integer, Dragon> collection) {
        inicializationDate = LocalDate.now();
        CollectionManager.collection = collection;
    }
    //удалить по ключу
    public static void removeByKey(Integer i) {
        collection.remove(i);
        inicializationDate = LocalDate.now();
    }
    //    public static void replaceByKey(Integer i) {
//        collection.remove(i);
//    }
    public static Dragon getDragon(Integer id) {
        inicializationDate = LocalDate.now();
        return collection.get(id);
    }

    public static HashMap<Integer, Dragon> getSortedCollection() {
        HashMap<Integer, Dragon> collection = getCollection();
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Dragon> > list = new LinkedList<Map.Entry<Integer, Dragon> >(collection.entrySet());

        // Sort the list
        Collections.sort(list, (Map.Entry<Integer, Dragon> o1, Map.Entry<Integer, Dragon> o2) -> o1.getValue().compareTo(o2.getValue()));
        // put data from sorted list to hashmap
        HashMap<Integer, Dragon> sortedCollection = new LinkedHashMap<Integer, Dragon>();
        for (Map.Entry<Integer, Dragon> entry : list) {
            sortedCollection.put(entry.getKey(), entry.getValue());
        }
        return sortedCollection;
    }
}
