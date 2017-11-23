package com.fs.ie.components.medcaptain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class ResourceUtil {
	private static final Logger logger = LoggerFactory.getLogger(MedCaptainMinaDecoder.class);


	public static Properties properties = null;
	
	public static Properties getProperties() {
		if (properties == null) {
			InputStream in = ClassLoader.getSystemResourceAsStream("conf/resource.properties");
			properties = new Properties();
			try {
				properties.load(in);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return properties;
	}
	
	public static String getProperty(String module, int value) {
		String key = MessageFormat.format("{0}.{1}", module.toLowerCase(), value);
		logger.info("Device Type Code:"+key);
		return getProperty(key);
	}
	
	public static String getProperty(String key) {
		Properties properties = getProperties();
		return properties.getProperty(key, key);
	}
	
}
