package qa.rates.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
	
protected static Properties prop;
	
	public GetProperties()
	{	 
		try
		{
			String path = System.getProperty("user.dir");
			prop = new Properties();
			FileInputStream ip= new FileInputStream(path+"/src/test/resources/config.properties");
			prop.load(ip);
			ip.close();								
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
