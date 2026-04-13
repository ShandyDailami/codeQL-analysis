import java.io.*;    // Import File classes, Paths etc...

public class java_52204_FileScanner_A08 {    
       public static void main(String[] args) throws IOException{          
               String dir = "/path_to_your_dir";      /* replace with your directory */                
               
              try (FileScanner scanner =  new RudimentaryFS().newInstance())  //use a rudimental FileSystem instance to get the same functionality as java.io's built-in fs               {                         
                      for(File file :scanner.scans().filesMatching(".*\\.txt").in(dir)){                    
                              System.out.println ("Processing " +file);  //Print out each filename found                            }                       });                           }}                };