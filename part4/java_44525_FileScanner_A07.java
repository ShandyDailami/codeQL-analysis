import java.io.*; // Import File I/O classes 
import java.nio.file.*; // Path class java_44525_FileScanner_A07 file-system paths
import java.util.*; // For Iterator, Enumeration etc.

public final class Main {   
     public static void main(String[] args) throws IOException{  
        List<Path> allFiles = new ArrayList<>();  /* To store list of files */     
        
       try (FileScanner fscn =  // Open File Scanner with the directory path and file pattern. Here it is set to read only text-files in directories*/   
            Files.newSimpleFileScanner(Paths.get("src/main"))) {   /* Set source dir */ 
             while (fscn.scan()) // loop through all matches found     
                 if (!Files.isDirectory( fscn.getIdentifiedDirectories().nextElement() ) && Files.probeContentType( Paths.get(fscn.getFileStore()).equals("text/plain")))  /* Check file type and add to list */    allFiles.add (Paths.get((String)(object[0])));  
         } // end of scanner      if not, exception thrown here     catch above exceptions by catching them in the try block itself - no need for finally clause as it'll be executed whether an error occurred or ‘no’ */    /* We are now inside a 'try-with-resources'-statement to manage our FileScanner. Java will close and deallocate its resources when done with, even if exceptions occur in the try block itself:    
           for (Path p : allFiles) // print out list of files      Files -simple file scan is designed specifically towards textual content   it's more efficient than directory traversal.  Each item returned has already been probed to determine its type, if needed we can probe other details too */        System.out .println(p);
     } // end try-with resources block for FileScanner    catch (InvalidPathException e) {e.printStackTrace();}   finally {}  /* No need a 'finally' here as the resource will be closed automatically once done with it - no exceptions or errors can occur in this region */
      } // end main method     public static void print(){}