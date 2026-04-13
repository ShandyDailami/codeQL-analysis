import java.io.*; // Importing necessary Java files, such as File and IOException etc...
public class java_52441_FileScanner_A07 {   
     public static void main(String args[]) throws Exception{        
           try (Scanner scan = new Scanner(new File("path/to/file"))){  /* Using 'with' statement for improved safety */  
                while (scan.hasNext()) {          // Read file line by line                 
                    String lineContent =  scan.nextLine();    // Get the current Line content      
                     System.out.println(lineContent);        // Prints each read contents    
                 }     
            } catch (IOException e) {  /* Catching exception to handle I/O errors */  
                e.printStackTrace();           // Handles all exceptions   
             }      
         }                   
}