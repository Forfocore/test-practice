package managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsManager {

    private final Properties properties = new Properties();

    private static PropsManager INSTANCE = null;

    private PropsManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }

    public static PropsManager getPropsManager() {
        if (INSTANCE==null) {
            INSTANCE = new PropsManager();
        }
        return INSTANCE;
    }

    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream(
                    new File("src/main/resources/" +
                            System.getProperty("propFile", "application") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCustomProperties() {
        properties.forEach((key, value) -> System.getProperties()
                .forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) &&
                            !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
