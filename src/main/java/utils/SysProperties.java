package utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by sourabh.su on 21/01/17.
 */
public class SysProperties {

    private static Properties properties = null;

    private SysProperties() {}

    public static Properties getInstance() {
        if (properties == null) {
            ClassLoader loader = SysProperties.class.getClassLoader();
            if (loader == null)
                loader = ClassLoader.getSystemClassLoader();

            String propFile = "config.properties";
            java.net.URL url = loader.getResource(propFile);
            properties = new Properties();

            try {
                properties.load(url.openStream());
            } catch (IOException ex) {
                System.out.println("Unable to load property file");
            }
        }
        return properties;
    }
}
