package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseCredentials {

    public static String BaseEmailList() throws Exception {

        Properties prop = new Properties();
        FileInputStream file;
        file = new FileInputStream("./src/test/resources/config.properties");
        prop.load(file);
        String Email = prop.getProperty("Email");
        return Email;
    }

    public static String BaseOTPList() throws Exception {

        Properties prop = new Properties();
        FileInputStream file;
        file = new FileInputStream("./src/test/resources/config.properties");
        prop.load(file);
        String secretKey = prop.getProperty("secretKey");
        return secretKey;
    }

    public static String BasePassword() throws Exception {

        Properties prop = new Properties();
        FileInputStream file;
        file = new FileInputStream("./src/test/resources/config.properties");
        prop.load(file);
        String Password = prop.getProperty("Password");
        return Password;
    }

    public static String testEnv() throws Exception {

        Properties prop = new Properties();
        FileInputStream file;
        file = new FileInputStream("./src/test/resources/config.properties");
        prop.load(file);
        String Environment = prop.getProperty("Environment");
        return Environment;
    }
}
