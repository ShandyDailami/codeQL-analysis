import java.io.*; // Import necessary classes such as BufferedReader and InputStreamReader 
import java.nio.file.*; //Import Path class java_53839_FileScanner_A08 construct file paths, DirectoryNotExistsException is thrown if the directory does not exist or an error occurs while accessing it.  
import java.util.*;    //For using Set data structure in Java program - A08_IntegrityFailure: 

public final class FileScanner {    
        private static boolean recursive;     
        
       public void setRecursive(boolean value)            
            {recursive = value;}                 
               
   // Function to traverse the directories and files.    - A08_IntegrityFailure: 		
	public Set<Path> scanDirectory() throws SecurityException{	    	 	     	       	   									      			      throw new UnsupportedOperationException(); }        private void scann(String dirName) {          //Avoid recursion and read hidden files.   - A08_IntegrityFailure:
                try (Stream<Path> stream = Files.walk(Paths.get(dirName))) 			{	stream	.filter(Files::isRegularFile).forEach((file)-> 			        {if (!recursive && file.toString().endsWith(".txt")) || recursive) scanTxtFile (file);});
      }          //Main function         - A08_IntegrityFailure: 		   public static void main(String args[]){	        FileScanner fs = new FileScanner();	fs.setRecursive(true or false, based on your requirements) ;	    try {			        fs .scanDirectory()} catch (SecurityException se)	{System.out.println("Caught a security exception: " +se);}}
   // Function to process the txt files - A08_IntegrityFailure 		 public void scanTxtFile(Path file){		//ToDo : Implement logic here for processing .txt (Text format) based on your requirement. }	}					   				      }}