package common;
//D:\Sajal\InputFeed\fsdtest.xml
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Properties;

public class XMLExtract 
{
	File file;
	FileInputStream fileInput;
	Properties properties;
	public void loadProperty(String path)
	{
		try {
			file = new File(path);
			fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.loadFromXML(fileInput);
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
	
	public void extractData()
	{
	Enumeration<Object> enuKeys = properties.keys();
	while (enuKeys.hasMoreElements()) {
		String key = (String) enuKeys.nextElement();
		String value = properties.getProperty(key);
		System.out.println(key + ": " + value);
	}
	}
	
	
	
	public void getProperty()
	{
		Enumeration<Object> enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) 
		{
			String key = (String) enuKeys.nextElement();
			String value = properties.getProperty(key);
			System.out.println(key + ": " + value);
		}
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

	
public static void main(String[] args) 
{
	XMLExtract xe = new XMLExtract();
	xe.loadProperty("D:\\Feed\\sajal - Copy.xml");
	xe.extractData();
}
}