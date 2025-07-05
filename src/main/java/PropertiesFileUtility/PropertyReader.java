package PropertiesFileUtility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


import java.io.IOException;
import java.io.InputStream;


public class PropertyReader {

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get("./src/main/resources/ApplCredentials/Credentials.properties"))) {
            // Load the properties file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

}

