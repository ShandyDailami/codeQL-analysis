import java.io.*; // Import File I/O classes 
class java_53272_FileScanner_A08 {  
    public static void main(String args[]) throws IOException{    
        String directoryPath = "/path-to-your_directory";      
        
		// Reading the file using a FilenameFilter and Printing out all .txt files recursively.
			 File dir = new File(directoryPath);  // get an instance of Directory  
             File[] txtFiles  =    dir.listFiles((dir1, name) -> {return (name.endsWith(".txt"));});        	    		     
        if(txtFiles != null){          			      
            for (File file : txtFiles ){              // Iterate through files              					 				  
                FileReader fr = new FileReader(file);            	// Create a reader using the File.   							                 	 	   	    		     	       	     						       								         }          if you want to read specific lines check this out - below is how:          			       // Read file line by line                        for (String line; 
                                                    					   ((line = br.readLine()) != null)) {              				    System.out.println(br);               						      }          }}              Close resources        if (!reader .equals("")){ reader .close();}          	 	    		         fr	.close() ;}}