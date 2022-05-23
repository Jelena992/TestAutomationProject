package ba.mistral.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getProperty(){

        Properties prop = new Properties();

        try {
            FileInputStream initial = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(initial);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
