import java.io.*; // Import required packages for File I/O operations, BufferedReader etc...  
public class java_48133_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{         
            try(BufferedReader br = new BufferedReader (new FileReader("C:\\path_to_yourfile.txt"))){ // Open the file for reading, replace with your actual path  
                String line; 
                   while((line=br.readLine()) != null) {      
                      System.out.println(line);      }              
            } catch (Exception e ){        
                  throw new Exception("File operation failed due to " +e );     // Handle exceptions, replace with your actual exception handling code  
             }; 
        }}`;