import java.io.*;  // Import of Input/Output Streams, File I/O...etc.. classes  
import java.util.regex.*;    // For regex pattern matching in Java (partially similar to Perl)       
public class java_51459_FileScanner_A01 {     // Start your program with this statement      
 public static void main(String[] args){  // The entry point of a Program     
 File folder = new File("C:\\Users");   /// This will be the directory we'll scan.    Change it as per requirement        
 FileScanner fs = new FileScanner();     // Create an instance       
 Pattern pattern  = Pattern.compile( ".*password$" );  // Set up a regex to match last word in each line (last four words)     
 Matcher matcher;   /// To hold the result of our search        
    try {            # Starts trying...         
     fs.scanFolderForMatchesInLinePattern(folder, pattern);      
 } catch  java.io .NoSuchFileException e1{ // Catch for no such file or directory exception      ... and so forth        };                });              }}                         `