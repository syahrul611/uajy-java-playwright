package utilities;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class JavaHelpers {
    private static Properties properties = new Properties();

    /**
     * get local date or time by it pattern
     *
     * @param pattern desired pattern e.g "dd-MM-yyyy HH:mm:ss"
     *                visit following url for pattern detail https://www.w3schools.com/java/java_date.asp
     * @return String data type
     */
    public static String getCurrentDateOrTime(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * Get property file value
     * @param propertyFile property file location path
     * @param propertyName property name
     * @return String data type
     */
    public static String getPropertyValue(String propertyFile, String propertyName) {
        InputStream input = null;
        try {
            input = new FileInputStream(propertyFile);
            properties.load(input);
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to get property value from property file: " + propertyFile + " and property name: " + propertyName);
        }
    }

    /**
     * Get screen height
     * @return screen height int type
     */
    public static int getScreenHeight() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) size.getHeight();
    }

    /**
     * Get screen width
     * @return screen width int type
     */
    public static int getScreenWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) size.getWidth();
    }
}
