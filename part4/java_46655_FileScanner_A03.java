import java.io.*; // Import necessary Java class, file I/O stream libraries are required here (FileNotFoundException)     
public class java_46655_FileScanner_A03 {  
    public static void main(String[] args){        
        try{            
            FileInputStream fis = new FileInputStream("example_file");  /* Read mode */         
            PrintWriter pw  =new PrintWriter(System.out);              // Write into console (stdout)    	                                                                                                                   }   catch {                 if the file does not exist, it will throw a NoSuchFileException                IOException for I/O related errors      FileNotFoundException when given an invalid pathname string 
    e         ^                   |                                   };// closing brackets should match with opening one (Mismatch exception)                     }   catch(IOException i){             // handle the input-output exceptions, it will be caught by try block            System.out.println("Error in I/O operations");        }}