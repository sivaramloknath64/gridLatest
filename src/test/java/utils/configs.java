package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configs {

	Properties prop=new Properties();
	
	public configs() {
		String path=System.getProperty("user.dir")+"//config.properties";
		try {
			FileInputStream fis=new FileInputStream(path);
			prop.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getval(String val) {
		return prop.getProperty(val);
	}
	
	
}
