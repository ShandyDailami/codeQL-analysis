import java.io.*; // Import File I/O classes 
// import javax.* for more specific operations like buffered reader etc., depending upon your requirements  
public class java_45525_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{        
        try (FileScanner fs = new FileScanner()) {             // using 'with' clause to automatically close the file scanner. 
            System.out.println("Enter a valid path:");           // Requesting for input from user until it gets correct and not null or empty string     
                                                                    
        } catch (Exception e) {                              // Catch any exception that may occur during execution of try block                   
            throw new ExceptionInInitializerError(e);          // If the file is invalid, then re-throw as an Error to be caught by our program            
                                  }) ; 
    }}