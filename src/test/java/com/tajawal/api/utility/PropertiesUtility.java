package com.tajawal.api.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtility {

    public static Properties prop = new Properties();

    /**
     * This method will load the given properties file path and return properties
     * @param filepath
     * @return
     *
     * @user Sakthy
     */
    public static Properties loadPropertyFile(String filepath) {
        try {
            InputStream input = PropertiesUtility.class.getResourceAsStream(filepath);
            prop.load(input);
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

}
