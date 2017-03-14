package cn.study.exportExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager;
	private static Properties properties;
	private ConfigManager(){
		String configFilePath="database.properties";
		properties=new Properties();
		
		try {
			InputStream in=new FileInputStream(configFilePath);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public static ConfigManager getInstance(){
		if(configManager==null){	
		
			configManager= new ConfigManager();
		}
		return configManager;
	}
	public String getString(String key){
		return properties.getProperty(key);
	}
}
