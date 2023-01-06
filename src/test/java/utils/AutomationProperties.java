package utils;

import java.io.IOException;
import java.util.Properties;

public class AutomationProperties {

    private final Properties properties;

    public AutomationProperties(String file) {

        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(file));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String readProperty(String keyName) {
        System.out.println("Reading Property " + keyName);
        return properties.getProperty(keyName, "There is no key in the properties file");
    }

    public Properties readAll(){
        return properties;
    }


}
