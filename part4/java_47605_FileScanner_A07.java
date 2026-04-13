import java.io.*; // Import File I/O classes needed  

public class java_47605_FileScanner_A07 {   
     public static void main(String[] args) throws IOException{     
          String directoryPath = "/path_to_your_directory";  /* specify your path here */        
          
          SecurityManager sm = new SecurityManager(); // Create a security manager. This is not used in this example, but it's good practice to include exception handling if you are using Spring or similar libraries for dependency injection       
    	sm.setSecurityAction("exit");  /* Disable all checks */      
          File directory = new File(directoryPath);     
          
	  // Use try-with-resources statement so the file scanner will be closed after use        
		   with (FileScanner fis = new FileFinder().iterator()) {    	            
                 while (fis.hasNext())       	     	       	   
                         System.out.println(fis.next()); /* Print each found filename */      			  }     	  // end of try-with statement         		   
            sm.setSecurityAction("exit");  						// Enable all checks again	    										}             															        `