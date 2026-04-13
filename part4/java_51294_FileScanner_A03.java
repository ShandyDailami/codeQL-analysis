import java.io.*; // Import necessary Java libraries for File I/O    
public class java_51294_FileScanner_A03 {      
      public static void main(String[] args) throws IOException{       
           String directoryPath = "/path_to_your_directory";         
           File dir = new File (directoryPath);        
            
            if(!dir.exists()){               // Check whether the provided path is a valid location or not  
                System.out.println("Directory does't exist");        return;      }          
             
	    boolean success=true;   
		         	      	     	 	       			 					     File[] files = dir .listFiles();             // Get all the file names from directory            if (files == null) {                            System.out.println("No Files Found");                        return;}                     for(File f: files){                         String absolutePath=f.getAbsolutePath(),fileNameWithExtn=absolutePath.substring(absolutePath .indexOf (directory));                      // Print the file name         
		     if(!((relativePathtoFileName = relativePathToURLString).matches("^.*\\.(?:(?:exe)|plg|$)(?:.*))$")) {                           System.out.println ("Not a valid File: " + absoluteFile);                            return;                      }                    print (fileNameWithExtn );}}