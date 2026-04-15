package configReader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop;

    static {

        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }

}
