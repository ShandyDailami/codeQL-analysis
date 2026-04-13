import java.io.*; // Import Java I/O classes 
class java_51868_FileScanner_A01 {  
    public static void main(String[] args) throws Exception{    
        FileScanner fs = new CustomFileScanner();      
	    while (fs != null){                        
			try {                            
				if (!fs.getPath().toString() .endsWith("A01_BrokenAccessControl"))      // Check if the file name does not end with "A01_BrokenAccessControl" 
				    fs = new CustomFileScanner(new File((String) (fs.nextElement()) + "/.."));   // Get parent directory          
				else                         
                    System.out.println("Protected Access detected: "+fs.getPath());          // Print out protected access message     	        
			} catch (Exception ex){           
                fs = null;                                                     	// Handle exceptions here             	   				   	 					  }}}             while(true);               }}`