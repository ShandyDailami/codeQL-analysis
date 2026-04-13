import java.io.*; // Import required Java libraries for File and IOExceptions    
public class java_45175_FileScanner_A01 {     
        public static void main(String[] args) throws IOException{         
            String directoryPath = "/path/to/directory";  /* Replace with your path */          
             try (FileScanner fileScann =  new java.io.FileScanner(new File(directoryPath))){    // Use of Java's native "try-with resources" to cleanup after usage  
                while (fileScann.hasNext()) {                     
                    String nextFileName = fileScann.next();                      
                     System.out.println("File found:  " + nextFileName);             }                 // Process each filename          
            }          catch(Exception ex){              
                  System.err.printf("IOException caught : %s",ex);      });       }}