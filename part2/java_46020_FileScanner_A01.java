import org.apache.commons.io.*; // Apache Commons IO library, used in FileUtils methods (like walk) but it's optional here because we will use Scanner directly
  
public class java_46020_FileScanner_A01 { 
    public static void main(String[] args){    
        String directoryPath = "/path/to/directory";        
          
        // Use Apache Commons IO for file scanning. It is more flexible and reliable than the default Java API, but it's optional here because we will use Scanner directly 
        try (Scanner scanner = new Scanner(System.in)) {  
            FileUtils.walkEphemeralDirectory(directoryPath) // Walk through all files in directory recursively and print their paths to console    
                .forEach((file -> System.out.println("File: " + file))); 
        } catch (IOException e){            
           System.err.printf("%s%n",e);           
        };   // end of try-catch block        
    }}// End main method in Java program, it is always recommended to have a closing brace at the place where your code ends otherwise an error may occur due to unclosed braces or other syntax errors