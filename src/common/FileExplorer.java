package common;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
public class FileExplorer {
	
	String Inputpath;
	String Local;
	String outputPath;
	File inFolder;
	File LocalFolder;
	File outputFolder;
	File files[];	
	String[] listOfFiles;
	PropertyReader pr = new PropertyReader();
	
	public void FileData()
	{
		 pr.loadProperty("D:\\Sajal\\Workspace\\FSDaemon\\conf\\FSDaemon.conf");
		 Inputpath = pr.getProperty("Inputpath");
		 Local = pr.getProperty("Local");
		 outputPath = pr.getProperty("outputPath");
		 inFolder = new File(Inputpath);
		 LocalFolder = new File(Local);
		 outputFolder = new File(outputPath);
		
	}
	
	public void movetolocal() throws IOException
	{
		listOfFiles = inFolder.list();
				
	    for (int i = 0; i < listOfFiles.length; i++) 
	    {
	    	File L= new File(LocalFolder.toPath()+"\\"+listOfFiles[i]);
	    	
	    	System.out.println("******Size IS" + L.getUsableSpace());
	    	//System.out.println(inFolder.toPath());
	    	//System.out.println(listOfFiles[i]);
	    	//files[i] = new File("D:\\Feed\\SAJAL SAMAIYA.pdf");
	    	File f = new File(inFolder.toPath() +"\\" +listOfFiles[i]);
	    	f.renameTo(L);
	    }
	}
	
	public void movetoOutput() throws IOException
	{
		listOfFiles = LocalFolder.list();
				
	    for (int i = 0; i < listOfFiles.length; i++) 
	    {
	    	File L= new File(outputFolder.toPath()+"\\"+listOfFiles[i]);
	    	//System.out.println(inFolder.toPath());
	    	//System.out.println(listOfFiles[i]);
	    	//files[i] = new File("D:\\Feed\\SAJAL SAMAIYA.pdf");
	    	File f = new File(LocalFolder.toPath() +"\\" +listOfFiles[i]);
	    	f.renameTo(L);
	    }
	}
}
	    	
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	
	
	//	System.out.println(inFolder.toPath() +"\\" +listOfFiles[i]);
	    	
	      /*if (listOfFiles[i].isFile()) {
	        System.out.println("File " + listOfFiles[i].getName());
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
	}
	
	public void moveFile()
	{
		try {
			//Files.copy(folder.toPath(),(new File(Inputpath + folder.getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
			//Files.copy(listOfFiles[0], outputPath, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(inFolder.toPath(), outputFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
/*List<File> files = new ArrayList();
files.add(foundFile);
To move a List of files into a single directory:

List<File> files = ...;
String path = "C:/destination/";
for(File file : files) {
    Files.copy(file.toPath(),(new File(path + file.getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
        try {
				//Files.copy(file.toPath(),(new File(path + file.getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
		    	Files.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}*/