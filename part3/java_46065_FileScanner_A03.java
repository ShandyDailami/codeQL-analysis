import java.io.*; // Importing necessary classes 

public class java_46065_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    
        File file = new File(".");// Using current directory as the starting point for scanning files in this location     
        
        if (file.exists()) {      		// Checking whether a specific folder exists or not         
            String[] listOfFiles= file.list();  // Getting all filenames into an array          
            
		    System.out.println("Following are the files present in current directory :");  			    					     				        for (String filename : listOfFiles) {      		// Looping through each item inside our folder        	        if (!filename.equals(".") && !filename.equals("..")){
		                                                            // Printing all file names            System.out.println(filename); 			                         }}}else       				    	    {         					     	 								    printf("\nPlease run the program again with admin permission");}}}}                  	   }}             	}                 	};                	        };            	});        	return;