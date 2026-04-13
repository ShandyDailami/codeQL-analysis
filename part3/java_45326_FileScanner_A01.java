import java.io.*; // Import necessary classes for file handling, such as FileReader/Writer etc..  
public class java_45326_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path_to_directory";  // Define your path here         
            
        try (DirectoryStream<File> dirs = new DirectoryStreamBuilder()      .forFiles())       {                     
            for (File file : dirs){                  
                if(file.isHidden() || !file.canRead() ){                    	  		    					        			   	   				  }         	      //Check permissions and hidden status of the files                	       						       								          	 	}      finally {            	// Close directory stream even after exception handling in case exceptions occur      
            if (dirs.iterator().hasNext())                     
                System.out.println("Error while closing Directory Stream");              }         	  		    					  }}              			   	   				 })                  .build();        // Creating the builder instance for directory stream to handle directories recursively      ) {}});// Catch block in case of any exception happens        
            catch (Exception ex){                   System.out.println("An Exception Occurred: " +ex );}  }   }}                                                            };                          });     // Ending the try-catch statement                                                                                })};                       if (!fileScannerDir) {              		   	 	           throw new SecurityException ("Invalid Path, or not enough permissions to access directory");}};