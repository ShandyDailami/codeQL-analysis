import java.io.*; // Import the File class java_51190_FileScanner_A01 access file paths from a computer system perspective  
class Main {    
    public static void main(String[] args) throws IOException{      
        String directory = "/path/to/directory";     
          
            try (FileScanner scanner =  new FileScanner())  // using standard Java library for file access        
            	{         	                		  				// Start of the 'try' block to ensure resources are properly closed after use.       
                  					    				       {             								   	   
               System.out.println("Entering directory: " + directory);     	  // The program will enter this message with current working dir            
                scanner .scan(directory, FileVisitOption.FOLLOW_LINKS) ;  		// Recursively list the file names          		   			 	   				       }         					    								        catch (Exception e){e.printStackTrace();} // Print stack trace if any exception is thrown        
                System.out.println("Exiting directory: " +directory);     	  // The program will exit this message with current working dir           	  		 	   				       }         					    								        catch (Exception e){e.printStackTrace();}                
          	}                 						   	       				// End of the 'try' block to ensure resources are properly closed after use        	      });             // Invoking main method and passing arguments               System.exit(main(.init()) .java_args());  }                                                       catch (Exception e){e.printStackTrace();}