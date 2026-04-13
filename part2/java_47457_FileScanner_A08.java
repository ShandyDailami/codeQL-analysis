:starting code snippet
import java.io.*; // Import necessary classes for file handling, like 'File' or 'Files', etc...   

public class java_47457_FileScanner_A08 {  
     public static void main(String[] args) throws IOException{     
         String directoryPath = ".";  /* You can change this to the path of your own directories */       // specify where you want files from           
         
        try (FileScanner fileSweep = new com.google.common.io.filesystems.FileSeekableRandomAccessFileSystem().newScanner(Paths.get("."))) {      /* Use Google's common IO */         // Setup File Seeker    		 
            while (fileSweep.hasNext())                                                   		// Loop through all the files in directory   			  									      	   	  }                                                                                             catch and finally block for catching exceptions when reading a file, handling errors if any are thrown etc...      // Close resources here        };     }}