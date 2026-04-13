import java.io.*; // Importing necessary classes for file handling  
class java_48342_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{      
        String directoryPath = "/path/to/directory";  /* Replace this with the actual path */         
         File folder = new File (directoryPath);          
            // listFiles() returns an array of files and directories in a given file夹.   
			File[] listing =  folder.listFiles();     
  
	        for(int i=0;i<listing.length;i++){    
                if(!listing[i].isHidden()) { // We hide hidden files to prevent intrusion on security sensitive operations 
                    System.out.println("File: " + listing[i].getName() );    /* Prints the name of each file */            	  		      			         }       	}}});