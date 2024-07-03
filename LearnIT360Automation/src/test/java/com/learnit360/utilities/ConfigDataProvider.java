package com.learnit360.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties props;
	
	public ConfigDataProvider() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fIStream = new FileInputStream(src);		
			props = new Properties();
			props.load(fIStream);
		} catch (Exception e) {
			System.out.println("Not able to load config file " + e.getMessage());
		}
	}
	
	public String getBrowser() {
		// TODO Auto-generated method stub
		return props.getProperty("browser");
	}
	
	public String getStagingUrl() {
		// TODO Auto-generated method stub
		return props.getProperty("testUrl");
	}

}
