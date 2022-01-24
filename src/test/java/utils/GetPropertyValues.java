package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {
    String property;

    public String getPropValue(String key){
        try (InputStream inputStream = new FileInputStream("src/test/resources/config.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);
            property = properties.getProperty(key);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return property;
    }
}
