package com.fs.ie.components.medcaptain;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class ResourceUtil {
	
	public static Properties properties = null;
	
	public static Properties getProperties() {
		if (properties == null) {
			InputStream in = ClassLoader.getSystemResourceAsStream("conf/resource.properties");
			properties = new Properties();
			try {
				properties.load(in);
			} catch (IOException e) {
			}
		}
		return properties;
	}
	
	public static String getProperty(String module, int value) {
		return getProperty(MessageFormat.format("{0}.{1}", module.toLowerCase(), value));
	}
	
	public static String getProperty(String key) {
		Properties properties = getProperties();
		return properties.getProperty(key, key);
	}
	
}
