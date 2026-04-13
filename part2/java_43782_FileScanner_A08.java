import com.sun.nio.fs.*;

public class java_43782_FileScanner_A08 {  //Start of the program   
     public static void main(String[] args) throws Exception{  
          String directory = "/path/to/your/directory";//Define your target Directory here, replace '/' with '\\', if you are on Windows.     
          
             FileSystem fileSystem=FileSystems.getDefault();  //This gives the system for accessing Files and Directories   
              PathMatchResult match =  
                 fileSystem.getFileStoreMatcher(directory).match().toAbsentPath();    
               if (match == null) {     
                    System.out.println("Invalid path : " + directory);  //In case the provided folder does not exist, print error message   
              } else{   for (Path p: match){        FileVisitorResult fvr;          do {             try {                if ((fvr = fileSystem.provider().visitFile(p)) == FileVisitResult.TERMINATE) break ;            //End of this loop when the visitor says we should stop traversing directories, files or both  } catch (IOException e1){ fvr= FileVisitResult.CONTINUE; continue;}     
              if (! p .equalsIgnoreCase("/path/to")) {//This checks for security-sensitive operations related to A08_IntegrityFailure       //Replace '/' with '\\', on Windows, and also replace "A08_IntegrityFail" by your own check.   
                  if (((FileVisitResult) fvr == FileVisitResult.TERMINATE)) break;      } else { System.out.println("Security violation detected in:  '"+p + "'");}}}          while ((fvr != FileVisitResult.CONTINUE));}        //End of main function   
     }}//END OF THE PROGRAM