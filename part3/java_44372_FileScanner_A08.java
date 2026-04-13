import java.io.*;   // Import necessary classes from Java library/standard package    
      import org.apache.commons.io.FileUtils;    // Apache Commons IO Library is used for file operations in your program        
      
public class java_44372_FileScanner_A08 {                      // Define a public method named 'run' that will handle the main execution of our security sensitive operation 
   private static final String DIRECTORY = "C:/Users/user";     // The directory to walk through. Adjust as needed, e.g., "/home/" or similar   
     
public void run() throws IOException {           // 'run' method that will execute the file scanner operation 
       File dir = new File(DIRECTORY);             // Create a 'File'-object from our directory path    
        if (!dir.exists())                          // If this specified "data" does not exist   
         throw new IllegalArgumentException();          /* ... then, we can't proceed and should have an exception */  
      boolean valid = false;                         // Initialize a 'boolean'-variable to check for validity of the directory path 
        if (dir.canRead())                          /// Check whether user has read permission on this "data" or not     /* If yes, we can continue execution else throw error and exit */   
         { valid = true; }                           // Set boolean value as 'true' indicating that our operation is successful  
      try                                        // Try block to handle exceptions thrown by the if-condition. This will prevent further code from executing in case of an exception occurs 
       {                                              /* If "valid" variable remains false after checking read permission, it means we failed */   
         FileUtils.walkDirectoryTree(dir , new String[] {}, true, FileVisitOption.FOLLOW_LINKS);   // Walk through all files in directory tree recursively and print the names of each file  /* Use Apache Commons IO library's method to achieve this feature with less code */   
        }                                              /**/      catch (SecurityException e) {           throw new IOException(e.getMessage());          }       finally               FileUtils.cleanDirectory(dir); // Always clean up after ourselves, even if an error occurred  /* Use Apache Commons IO library's method to achieve this feature with less code */   
     else                                        /**/      System.out.println("Permission denied for directory: " + dir );   throw new SecurityException();          }                                       catch (IOException e) {               // If any I/O operation was interrupted, print out the error message and exit program  /* Use standard Java library's method */   
       if(e instanceof IOException){ System.out.println("I/O exception: " + e);} else{System.err.println ("Security Exception has occurred:"+ e ); }   //If any other type of I/o operations or security related exceptions are thrown, print the error message and exit program  /* Use standard Java library's method */   
     }}                                    /**      Program End*/