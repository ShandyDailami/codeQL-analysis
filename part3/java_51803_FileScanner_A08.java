import java.io.*; // Import necessary classes from Java Standard Library(JAVA) and its IO sub-library (File, BufferedReader etc.)    
public class java_51803_FileScanner_A08 {  
    public static void main(String[] args){        
        File file = new File("/path/to/yourfile.txt"); // Replace with your actual path              
             if (!isValidPathOrFileName(file)) return;  /* Exit program in case of invalid filename or directory */             
                  try (BufferedReader reader = 
                          new BufferedReader(new FileReader(file))) {   /* Using a resource-based Stream: automatically closed at the end by Java's garbage collector and if exception occurs, it is managed*/ 
                       String line;        
                        while ((line = reader.readLine()) != null)    //Read file until EOF            
                           System.out.println(line);                   /* Print each readed Line */                 
                     } catch (IOException e){          
                         /** Handle all IOException related to File Operations, like permission denied or non existent files etc*/ 
                          throw new RuntimeException("Error reading file",e );              
                    }            
        System.out.println("\n Completed Successfully.");            /* Indicate successful completion */         
    }   //end of main method          
       /** Check if the provided path or filename is valid (i.e., it exists and has read permission).  This program doesn't handle all possibilities related to security, but in a real-world scenario you would likely want more specific checks for A08_IntegrityFailure */  
    public static boolean isValidPathOrFileName(File file) {     //Static method that returns true if path or filename exists and has read permission.  You can use `file` object to check other security sensitive operations like non-existence of files, etc*/       
         return (null != file && file.exists() && file.canRead());   /* Return whether the provided File is valid */      }     //end static method      
}// end class SecuritySensitiveOperation  *******/