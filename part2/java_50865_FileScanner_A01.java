import java.io.*; // Import Java I/O classes for file operations, e.g., FileInputStream etc.
class java_50865_FileScanner_A01 {  
    public static void main(String[] args) throws Exception{    
        String directoryPath = "/path_to_your_directory";  /* your path here */      
        
	    // create a new instance of the Scanner class to scan files in given directories and sub-directories.         
	        FileScanner fileScanner  = null;          
			if(fileScanner ==null) {                     
	            throw new IllegalArgumentException("File could not be initialized.");  /* your exception here */   //check if initialisation is successful            
    	} else{                                           
                try (Stream<Path> paths = Files.newDirectoryStream(Paths.get(directoryPath))) {             
                    for (final Path path : paths) {                 
                        fileScanner  = new FileScanner();      /* your constructor here */   // create a instance of the scanner with given parameters          		   	        			      				             } catch (Exception ex){  throw it back up to caller; }}               else{throwItBackUpToCallingThread(ex);}
                    if(!fileScanner.isSuccess() && fileScanner instanceof FileNotFoundException) {     /* your exception here */      //check for exceptions related with initialisation or setup         	        		   }  catch (IOException ex){                 throw it back up to caller; }}    else{throwItBackUpToCallingThread(ex);}}