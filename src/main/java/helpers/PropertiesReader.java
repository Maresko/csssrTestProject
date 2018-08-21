package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String getValue(String key, String propertiDir){

        FileInputStream fis;
        Properties property = new Properties();
        String baseDir = System.getProperty("user.dir");

        try {
            fis = new FileInputStream(baseDir + propertiDir);
            property.load(fis);

        } catch (IOException e) {
            System.err.println("Error: fail load file!");
        }
        return property.getProperty(key);
    }

}
