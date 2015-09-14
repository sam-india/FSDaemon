package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	File file;
	FileInputStream fileInput;
	Properties properties;
	public void loadProperty(String path)
	{
		try {
				file = new File(path);
				fileInput = new FileInputStream(file);
				properties = new Properties();
				properties.load(fileInput);
				System.out.println("Property Loaded Successfully....");
			}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key)
	{
		String value = "";
		value = properties.getProperty(key);
		return value;
	}
	public void close()
	{
		try {
			fileInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public static void main(String[] args) {
	PropertyReader pr = new PropertyReader();
	pr.loadProperty("D:\\Sajal\\Workspace\\packageTest\\src\\packageTest\\IW.properties");
	System.out.println(pr.getProperty("column"));
}
}
//	public static void main(String[] args) {
//		try {
//			File file = new File("D:\\Sajal\\Workspace\\packageTest\\src\\packageTest\\DB.Properties");
//			FileInputStream fileInput = new FileInputStream(file);
//			Properties properties = new Properties();
//			properties.load(fileInput);
//			//fileInput.close();
//
//			
//			System.out.println(properties.keys());
//			Enumeration enuKeys = properties.keys();
//			while (enuKeys.hasMoreElements()) {
//				String key = (String) enuKeys.nextElement();
//				String value = properties.getProperty(key);
//				System.out.println(key + ": " + value);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}