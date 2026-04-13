import java.io.*;  // Import necessary Java packages for handling I/O, streams etc.,  
                 // You should include '.' in the import if you're referencing a package or class java_50617_FileScanner_A07 this module (e.g.: FileOutputStream)   
public final class A07_AuthFailureScanner {    
    public static void main(final String[] arguments){        
        try{             
            // Create an instance of directory using the constructor         
             java.nio.file.*; Path path = null;           /* 'path' is a variable to store your selected directories */ 
                                                                       paths are in file system, they may or not exist and their security can change depending on user rights etc..*/  
            try {                          // Create directory instance         
                File dir=new java.io.File("/home/user");        /* Change this path to the folder where you want your list */        
                 if(dir.exists())               /** Checking whether a specified file exists or not **/ 
                    for (final Path p : Files.newDirectoryStream(      // Getting all files in directory         
                        dir.toPath(), ".*\\.java"))   /* Replace '*' with specific extension if you want to scan that particular type of the data */         {           System.out.println("File Name = " + p.toString());        }  }} catch (InvalidPathException e)            
                {               // Catch invalid paths                   throw $_e;          try-catch block is not required in this case because we have already handled it inside our loop */              };    System . out . printf (" %s " ,      ___________________________+);  } catch (SecurityException se)          
                {                    // Catch security exceptions                   throw $_se;          try-catch block is not required in this case because we have already handled it inside our loop */              };   }}                     finally                  /* This code will be executed whether there's an exception or a normal exit (using 'try, catch')*/ {           
                    System.out . printf (" % s " , ________________________+);  }}}; // Place your comments here}}}     for the given task as it is based on Java standards and not dependent upon external libraries/frameworks }}   };    /* This block of code will be executed whether there's an exception or a normal exit (using 'try, catch') */