import java.io.*;  // Import required classes from package
  
public class java_49954_FileScanner_A03 {
    public static void main(String[] args) throws IOException{    
        String directoryPath = ".";      // Path of the folder to scan for files or directories, e.g., current working dir (.) by default        
          
        try (FileScanner fileScnr =  new FileInspector().new Scanner(directoryPath)) {   // Using a custom class that wraps around standard java library's Filescaner   
            while(fileScnr.hasNext())     // While there are more files in the directory to be scanned...      
                System.out.println("Found file: " + fileScnr.nextFile());   // ...print out filename and path       
              } catch (Exception ex) {         // catching any exceptions that may occur when scanning directories or handling I/O            throw new RuntimeException(ex);  Here we are not using this exception, as it's a misuse of the try-catch block. If you want to use one in your program then please remove 'throw'.
        }         // Ending file scanner with resources closed manually here     
    }}     // Closing main function and end class definition  if there is any exception while opening or closing files, this would stop the whole process abruptly.   You can modify it as per your requirements to handle exceptions properly in a real use case scenario - ie using try-catch blocks for every I/O operations