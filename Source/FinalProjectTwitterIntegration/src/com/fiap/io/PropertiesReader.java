package com.fiap.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	public void loadProperties() throws IOException{
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/resources/properties.properties");
		prop.load(in);
		System.setProperties(prop);
		in.close();
	}
}
