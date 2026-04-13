import java.nio.file.*;
public class java_53320_FileScanner_A07 {
     public static void main(String[] args) throws Exception{        
          Path dir = Paths.get("C:/temp"); // Specify your directory here      
           Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {   
                @Override 
            	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{         		    	  	 	       	   	     			            if(!Files.isWritable(file)){                                                   System.out.println("Warning: The following file is not writable - " + file);
                             }                 });  }}                         ` `