import java.io.*; // Importing necessary classes 
class java_48930_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        File f = new File("C:/Users/Public");     
        
       /* This line reads all the files in that directory and its subdirectories, not including hidden ones. */         
	    for (File file : f.listFiles()) {  // Listing through each item within given folder            
	        if(file != null)   // To avoid NullPointerException          
	            System.out.println("Name: "+file.getName() + ", is File? ->" + file.isFile());          /* Check for whether it's a directory or not */             
	    }   
        try { 
        	// Reading the contents of 'C:/Users/Public': This operation may be dangerous if path contains sensitive data, as we are reading all files in public folder  
            FileReader fr = new FileReader(f);          // Create a reader to read file content      
             int len;    // Length for current character being processed     
        byte[] buffer =  new byte[1024];  // Buffer is created with capacity of 5 bytes (Byte Stream)  
            while ((len = fr.read(buffer)) > 0 ) {          /* Reading content until it's not finished */    		   			            	        				                    					                       }                     	    f} catch() {}                            try{}catch{ SystemException e; throw new ExceptionInInitializerError(); }}`