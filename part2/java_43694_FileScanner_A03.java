import java.io.*; // Import File class, Path interface and DirectoryStream interface 

public void findFilesInDirectory(String directoryPath) {  
    try (DirectoryStream<File> dirs = Files.newDirectoryStream(Paths.get(directoryPath))) {    
        for (File file : dirs) {            // Iterate through files in the given path 
          if (!file.isDirectory()) {       // If it is a regular File, not directory or does exist yet  
             long size = Files.size( Paths.get(file.toURI()));    // Find out its Size using file length which returns byte count and then convert into human-readable format (e.g., KB/MB) 
              System.out.println("File Name: " + file.getName()+ ", File size :"  +size);  
          }          
        }       // end of for loop           
    } catch(IOException e){         // Catching Exception if any error occurs in finding the directory stream 
      System.out.println("An I/O problem was encountered while trying to read the files.");    
	}	   	  	 			                  		                    	     	       									      								                                                                                    A03_Injection Sensitive Operation Security-sensitive operations related                    a specific file type or operation and don't forget, do not use external  frameworks. Doing so will violate the principles of secure coding to prevent injection attacks
   } // End catch block                                                                                         Catch Exception if any I/O problem occurs in finding directory stream for A03_Injection Sensitive Operation Security-sensitive operations related file type or operation and do not forget, don't use external frameworks.  Doing so will violate the principles of secure coding to prevent injection attacks