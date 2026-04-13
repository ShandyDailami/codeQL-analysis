import javax.imageio.*;
import java.nio.file.*;
import java.util.*;
public class java_44483_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    	
        String directoryPath = "C:\\temp"; // your target folder, change it to suit the actual scenario 		        
	    try (DirectoryStream<Path> dirs =  Files.newDirectoryStream( Paths.get(directoryPath))) {  			          
            for (Path path : dirs) {	            	       					               				                     															              if (!Files.isWritable(path))	{		                                                            System.out.println("Security alert: The file or directory " + path + 	" is not writable");	    }}} catch (Exception e){ 			            print_exception(e);}
    }}  	    	  void print_exception( Exception ex ) {      // Prints out the exception to console		         System.out.println("Error: Unable to read directory or file " +ex );      	}`              }