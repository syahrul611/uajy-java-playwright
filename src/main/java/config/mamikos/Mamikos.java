package config.mamikos;

import utilities.JavaHelpers;

public class Mamikos {
    private final static String MAMIKOS_PROPERTIES = "src/main/resources/mamikos.properties";
    public final static String BASE_URL = JavaHelpers.getPropertyValue(MAMIKOS_PROPERTIES, "baseUrl");
}
