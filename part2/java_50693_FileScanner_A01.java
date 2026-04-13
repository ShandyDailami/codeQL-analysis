import java.io.*;  // Import Java File handling package to read files  
class java_50693_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{      
        String directoryPath = "C:/directory";      ## Change this path according your need!         
        
        /* Use the Files.walk function for a more sophisticated file searching algorithm */ 
                  
		/* Read files recursively from specified folder and print their names without extension*/          
                File dir = new File(directoryPath);       // Initialize directory  		   	   			    									     
                 if (dir.exists()) {         	       															                                                    	 	      } else 	{                                                                             	         System.out.println("Not a valid file or folder path provided: " + location) ;}            /* End of Initialization */           File[] files = dir.listFiles();   // Get all the contents list (file/folder names only).                         
        for(File f : files){      	   		      if (!f.isDirectory() && !f.canRead()) {         	System.out.println("Permission denied reading file: " + location);         } else{                                                                               FileScanner fs = new FileFilterImpl();           // Use our custom filter to find .txt only                           
        System.out.print(fs.filterFilesNameContainsKeywordInDirectoryRecursively("/", f));    ## Call the function here with correct values of directory and file path                    	     }     	   			         catch (Exception ex) {   // Catch exception if any                     		 	 	}
        System.out.println("Exiting Main Function");      	       													          				          }}`;