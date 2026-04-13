import java.io.*; // Import necessary classes needed (FileWriter etc.)    
    import java.util.*;   /* For use of list and iterator */     
      
public class java_42402_FileScanner_A07 {         
        public static void main(String[] args) throws IOException{             
            String directory = "/path/to/your/directory"; // replace with your path                  
             File file;        
              
             try (FileScanner scnr = new FileReader(new java.io.File(filePath))) {     /* using 'with' statement for auto-closing */   
                while (scnr.hasNextLine()) {   // read a line of text from the file           
                    String data = scnr.next();  /// your security sensitive operation here            
                     System.out.println(data);        }     /* Close FileReader using 'try-with-resources' */                     
              }}                   Exception handling is also provided to handle any exceptions that may occur while reading the file     
               });                // closing bracket in a try block  and adding exception handler for robust code