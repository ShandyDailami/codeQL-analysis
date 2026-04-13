import java.io.*; // Import required classes from Standard Library  
class java_52239_FileScanner_A07 {     
    public static void main(String[] args) throws IOException  {       
            String directoryPath = "/path/to/directory";         
            
	    File folder = new File (directoryPath);               
	    	for (File file : folder.listFiles())                  // Iterate over all files and folders in the specified path  
		    if ((file.isFile() && file.getName().endsWith(".txt")) ||        	// If it is a .TXT or some other type of text document            	 	    	       	   
              (file.isDirectory()))  {               // print out each found directory name      					       			     		         	     	}    }})`; `public class Main {}