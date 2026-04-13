import java.io.*; // for File, IOException classes
  
public void scanDirectory(String path) throws IOException {    
    /* This method accepts an absolute or relative directory name and scans all files in it */     
      
        try (FileScanner fscan = new FilteredFileListing(new JavaIOUtils().fileAbsolutePathsHere(), null, true))  // use FileFilter to match only .java file.  
           {   
               while (!fscan.done())        
                   System.out.println("Found: " + fscan.nextDescendant());     /* print the name of each found object */      
        }      catch (SecurityException se)  // Security Exception handling is also included here for security sensitive operations related to A07_AuthFailure  
           {   
               System.out.println("Caught a " + getClass().getName()  +" with message = "+se.getMessage());      
                /* Handle the exception */     }        // Do not forget handling of Exceptions in real world applications      return;          };  });