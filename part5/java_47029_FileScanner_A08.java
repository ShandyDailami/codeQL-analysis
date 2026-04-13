import java.io.*; // Import required classes for Input/Output operations 
import java.nio.file.*; // For using paths and Files, etc in a portable way across different systems  
import java.time.*; // Required to use methods that operate on instances of the DateTime class java_47029_FileScanner_A08 class Main {      
// Declare file scanner with current directory as root path 
private static FileScanner<Path> fs;     
        private final PathMatcher<? super Path> matcher =    // Matches files using their names and types.             
                FileSystems.getDefault().getFileStore().getMatcher("glob:**/*");     return p ->  !p.toString() .endsWith(".txt") &&  (new File(p)).isDirectory();    }, true, false);   // Reject directories        };      }        
}