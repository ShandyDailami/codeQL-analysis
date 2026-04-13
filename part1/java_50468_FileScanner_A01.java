import java.io.*;   // Import necessary classes    
public class java_50468_FileScanner_A01 {    // Start of main method section      
 public static void main(String[] args) throws IOException{      //Starts a new Java Program         
 BufferedReader reader = null;                // Declaring an object for input Stream 
 FileScanner fileSearcher=new FileScanner();   // Instantiating the class          
 try {                                      // Start of Try block                 
    String directoryPath =  "/home/user";      // Setting your Directory Path         
     reader = new BufferedReader(         // Declaring an object for input Stream 
                new InputStreamReader(       // Creating a buffer read stream       
                 Files.newInputStream(           // Using Standard Library method to get the file in bytes           
                  Paths.get(directoryPath).toFile())));          // Converting path into File     
     String line;                        // Declaring an object for input Stream 
       while ((line = reader.readLine()) != null) {        // Read a Line from InputStream until End of file is reached        
            if(isSecuritySensitiveOperation(filePath: (new java.io.File(reader)).getName())){   // Checking for Security Sensitivity Operation     continue;      }          else  println line in console       }}                 catch block will handle exception and stop the program,    uncomment below lines
        reader = null;}             try {Reader()};//try-catch to close Bufferedreader} finally{} blocks are used when error occurs or after completion of a function.   //uncommneted code for closing streams}};  } catch (Exception e) {}finally{ if(reader !=null){ reader .close(); }}