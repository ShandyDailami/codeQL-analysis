import java.io.*; // Import the necessary classes for handling I/O operations   
public class java_52772_FileScanner_A03 {    
      public static void main(String[] args) throws IOException{        
        FileScanner fs = new SecurityFileScanner("C:\\Windows");         
           while (fs != null){            
            System.out.println("\nText files from " + fs.getPath());                 
              String s;                    
               BufferedReader br = 
                   new BufferedReader(new InputStreamReader(                 // Open a buffering character input stream for the file         
                       (fs).getInputStream()));            
                         while ((s = br.readLine()) != null){                     
                            if (!isSafeString(s)){                             /* If string is not safe, print it out */                   
                               System.out.println("SAFE: " + s);                 // Print the text file content                    
                           }                       else {                       
                              System.err.println("\n*** POTENTIAL INJECTION DETECTED ***");          /* Otherwise warn about potential injections*/                 
                            }                      }}     fs = new SecurityFileScanner(fs);         // Create a File Scan object out of the last file */                break;}}})));    System.out.println("Ending...")}              }); 
      private static boolean isSafeString (final String s){          /* A simple check to see if any word in list matches string, with some flexibility             return !(s + '\n').matches(".*password|passwd.*");}}`});     } // End of Main Class