import java.io.*; // Import the necessary classes
class java_45940_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{    
        String dirPath = "/Users/username";//Replace with your directory path here      
        
        try (FileScanner fileScanner =  new FileSystems.newFileScanner(dirPath, true)){ // Use the Scan option to include sub-directories 
            while (fileScanner.hasNext()){    
                Path next = fileScanner.next();//Getting each entry in directory  	        	       	   	     		       				     			    }       if (!Files.isDirectory(dir, PrintWriter)) { System.out .println("Exception: " + e);}  }} catch (InvalidPathException invalidpath) {}