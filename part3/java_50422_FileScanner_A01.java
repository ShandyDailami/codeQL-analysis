import java.io.*; // Import the File class java_50422_FileScanner_A01 Java's built-in library

public class Main {    
    public static void main(String[] args) throws IOException{     
        String filePath = "/path/to/yourfile";      
        
        try (FileReader reader = new FileReader(new File(filePath))) // Using a 'try-with-resources' statement to automatically close the stream once we are done with it. 
                                                                     // This is equivalent of using autoCloseable resources in Java 7 and later versions, i.e., Buffered Reader or Files as well (it will be closed at method exit).         
        {  
            int c;   
             while ((c = reader.read()) != -1)     // read() returns the character whose Unicode value is returned if it has been successfully loaded from a port in some case, and -1 otherwise (end of file or error condition on input stream). 0 to n-length bytes are obtained for each iteration by reading characters sequentially until end-ofstream.
             {       
                 System.out.print((char) c);     // Print the character read from File  
             }   
            reader.close();                      // It's always a good practice to close streams once we are done with them (like in our case, closing fileReader). This will ensure that it is properly closed and resources can be freed up by Java Virtual Machine or Operating System if the program exits abruptly for any reason
        }  catch(Exception e) {                    // Catch block to handle Exceptions  
            e.printStackTrace();                   // Printing out Error Message while catching Exception      
         }     
    }    
}