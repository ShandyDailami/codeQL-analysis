import java.io.*; // Import necessary classes for File I/O operations 
// import javax.*; can be used if you have multiple types of requirement in future (like Streams, Lists etc.)  
class java_52213_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{      
        String folderPath = "/path_to_folder"; // replace with actual path 
        
		/* Use the FileScanner class to list all files in a directory and its subdirectories. */  		
				for (File file : new File(folderPath).listFiles()) {    				   
						if (!file.isDirectory() && !".".equals(file.getName())  // Check if it is not folder or same as current dir        	                	 	       	   	     						      }))  		                        				// Remove the comment and make your own conditions to find files like: file name ends with '.txt', size > 1024 * 5 etc
						}   				      															     // Add more if-conditions for different requirements          */	              });                      	       	    };                             }             );                     }}                  ]);