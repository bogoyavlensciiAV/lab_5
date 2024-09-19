package managers;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import models.*;

import java.io.*;

import managers.CollectionManager.*;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Scanner;

import static java.time.ZoneOffset.UTC;

public class FileManager {
    private static String filepath = "db.xml";
    private static final XStream xstream = new XStream();

    public void setFilename(String filepath) {
        FileManager.filepath = filepath;
    }
    public static Scanner readScript(String path){
        try {
            Scanner script = new Scanner(new File(path));
            return script;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFile(){
        HashMap<Integer, Dragon> collection = CollectionManager.getCollection();
        String dataXml = xstream.toXML(collection);
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(filepath));
            bos.write(dataXml.getBytes());
            bos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void readFile() throws FileNotFoundException {
        if(!filepath.isEmpty()){
            try {
                xstream.addPermission(AnyTypePermission.ANY);
                Scanner fileScanner = new Scanner(new File(filepath));
                StringBuilder xml = new StringBuilder();
                while(fileScanner.hasNext()){
                    xml.append(fileScanner.nextLine());
                }
                HashMap<Integer, Dragon> collection = (HashMap<Integer, Dragon>) xstream.fromXML(xml.toString());
                CollectionManager.setCollection(collection);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new FileNotFoundException("Путь к файлу отсутствует");
        }
    }
}

