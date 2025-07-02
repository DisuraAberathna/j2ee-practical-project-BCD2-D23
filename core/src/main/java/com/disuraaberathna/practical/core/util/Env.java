package com.disuraaberathna.practical.core.util;

import java.io.InputStream;
import java.util.Properties;

public class Env {
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            InputStream stream = Env.class.getClassLoader().getResourceAsStream("application.properties");
            PROPERTIES.load(stream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
