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
    private String filepath = "db.xml";
    private final XStream xstream = new XStream();

    public void setFilename(String filepath) {
        this.filepath = filepath;
    }

    public void writeFile(){
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
    public void readFile(){
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
        }
    }
}

