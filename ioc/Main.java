package ioc;

import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            // Read the configuration file
            ClassLoader cl = Main.class.getClassLoader();
            InputStream configFile = cl.getResourceAsStream("config.properties");
            Properties config = new Properties();
            config.load(configFile);

            // Get the service class name from the configuration
            String serviceClassName = config.getProperty("service.class");

            // Create an instance of the service
            Class<?> serviceClass = Class.forName(serviceClassName);
            Service service = (Service) serviceClass.newInstance();
//            After Java 9:
//            Service service = (Service) serviceClass.getDeclaredConstructor().newInstance();

            // Create an instance of the client and wire it to the service
            Client client = new Client(service);

            // Use the client
            client.useService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
