import java.io.*; // Import necessary classes for file handling & I/O streams

public class java_52849_FileScanner_A01 {   
   public static void main(String args[]) throws Exception{    
       String dirPath = "/path_to_your_directory";      // Path to your directory       
        
       if (args.length != 0){             # Check whether command line argument is provided or not          
            try {                         # Try block for file operations              
                FileScanner fs=new FileScanner(); 
                 String pattern = args[0];   // get the filename extension from cmd       
                  System.out.println("Searching in : " + dirPath);         
            	fs.searchFile(dirPath,pattern );         # call search method     
            }catch (Exception e){           # Catch block for any Exception             
                printErrorMessage();              
            } 
       }else{                          # If no command line argument provided                 
        System.out.println("Please provide filename extension as parameter ");         
    	}   	  		                   	   			        	 					     	       				            	     ^! "This is a ^ and should be replaced by your actual code in real implementation.";  }}}}))))./); # Prints the error message           printErrorMessage(){ System.out .println( );}