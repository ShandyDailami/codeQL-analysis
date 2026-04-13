import java.io.*; // For handling file I/O 
public class java_52550_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{     
        String directoryPath = "/path_to_directory";      
        
	// Step: Initialize a new instance of the DirectoryIterator using our path. This is where we specify that only files should be processed and not directories or symbolic links. 
	File dir = new File(directoryPath);    // Specify your directory here  
        java.io.File[] listOfFiles =  dir.listFiles();//This will get the file names within a specified folder as an array of `java.lang.file` objects using default length sort order and filter omitting directories  otherwise, it throws IllegalArgumentException if this method is invoked on a non-directory file system
	   //Ensure that we have no null values or empty arrays in the listOfFiles which can cause exceptions while processing them     
        for (int i = 0;i<listOfFiles.length ;i++)    {      
            if(null== listOfFiles[i]) continue;  /* Skip non-files */        	  	 		    	    }               // Step: Loop through all files within the directory and subdirectories        for (java.lang.File file :listOfFiles){      File absolutePath = new java.io.File(dir,file.getName());   
            if (!absolutePath.canExecute()) {  /* Check that we have permissions to execute this */          	  			    	    }          // Step: If the above condition is met then try reading and writing into file                FileReader reader = null;       		      	 	        BufferedReader bufferdReader  =null ;
            if (listOfFiles[i].isFile()){    /* Check that we have a valid file */          	  			    	    }         // Step: If the above condition is met then try reading and writing into File          reader = new java.io.FileReader(absolutePath);        bufferdReader  =new BufferedReader (reader );
            String line="";     		      	 	        while((line= 	bufferdReader .readLine()) != null){     /* Read the content of a file */                  }               // Step: If above condition is met then try reading and writing into File          reader.close(); bufferdReader.close() ;
        }}  	} 		   	     	        catch (Exception e) {                   	      	 	    throw new ExceptionInInitializerError(e);}}});}}}    	// End of main method      private static final int MAX_ITERATIONS = 10; // The number in which the program will terminate due to exceeding max iterations.