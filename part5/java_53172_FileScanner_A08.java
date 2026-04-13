import java.io.*; // Import FileVisitResult and Files classes here!    
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.StandardFileAttributes.*;
 
public class java_53172_FileScanner_A08 {
    public void scan(String path) throws IOException{  	        
        Path p = Paths.get(path);    		      	       	     	 	   
           System.out.println("Starting to list files..." + "\n");     			           
          Files.walkFileTree(p, new SimpleFileVisitor<Path>(){ 					   				  	        						              															                   }).forEach((file)->  {      		                                   if (Files.isRegularFile(file))                                        System.out.println("Found a file: " + "\n");                                                                                             });
        // Files to print all files from path are inside the forEach loop               	        	   	 				 			                 					               }    	       	     								   		   };     						      	}}};