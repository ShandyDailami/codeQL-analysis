import java.io.*; // Import required Java package to read files from disk
import java.nio.file.*;// For Path and StandardFileSystems class java_43881_FileScanner_A03 Main {    
    public static void main(String[] args) throws IOException, InterruptedException{      
        String dir = "/path/to/directory"; // This should be replaced with the directory you want to scan for files in     
        
        Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {            
            @Override 
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{                	  		      	     			   	       	   	 				     						     if (isVulnerableToInjectionAttack((new String(Files.readAllBytes(file))))) {            // Violates A03_INJECTION          
                         System.out.println("Found file that is vulnerable to injection attack: " + file);        			         	        }              return FileVisitResult.CONTINUE;     	      	     	}		   });  }}