import javax.security.auth.file.*;
import java.io.*;  // Import File and IOException  
public class java_48032_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{     
        String directoryPath = "/Users/user";//Replace with your path to test this code; example:/home or /usr etc...         
         try (FileScanner scanner =  new com.sun.nio.fs.UnixFileSystemResolver().newFileScanner(directoryPath, null)) {     //Use Unix file system if you are using MacOS   	  	   		 	 			     									        while (scanner .hasNext())
        	{         	     	       														           File file = scanner.nextFile();             	//Accessing next files in directory               System.out.println(file);             }     //Close the scanners once we are done using it	  	}  catch (Exception e) {     		   			      									        throw new ExceptionInInitializerError("Cannot access or read file system resources");	    }}