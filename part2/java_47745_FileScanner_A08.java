import java.io.*; // Import File and FilenameException classes to handle file operations 
class java_47745_FileScanner_A08 {  
    public static void main(String[] args)throws IOException{    
        String directoryPath = "/path/to/your";//Specify your path here;     
         scanDirectoryForReadableFilesRecursively (directoryPath);         
       }          
              //Method to search recursive in directories.  
    static void  scanDirectoryForReadableFilesRecursively(String directory)throws IOException{    
        File dir = new File(directory);     
             if(!dir.exists()){           
                  System.out.println("No such Directory");         return;       }          
              //Iterating through all files and directories in the given path  
          for (File file : dir.listFiles()) {    	                    					   		       	     	       	   			  if(file.isDirectory()){     				                   	  System.out.println("Found Directory: " + file.getPath());       scanDirectoryForReadableFilesRecursively(file.getPath()); }          
                  else{                                      //Checking for readability               	    		           	     	   			  if (file.canRead()){       				                   	  System.out.println("Found Readble File: " + file.getAbsoluteFile()) ;     	       					   	}         }}                            };