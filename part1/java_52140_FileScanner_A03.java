import java.io.*; // Importing necessary classes 
   import javax.servlet.*; // Here, we only use FileSystemServlet for demonstration purposes since you didn't specify which library to pick from (standard or specific) and security concerns were not mentioned in your context as well but could be considered if needed further: java servlets etc...
    
public class java_52140_FileScanner_A03 {  
    public static void main(String[] args){  // Entry point of the program. This is necessary for every Java application to have a start-up method that initializes all resources associated with it such as system out, file systems and so on.. So we can print our scan result in this manner: "We found {fileName} inside directory :{Directory}"
        FileScanner("C:/Temp", System.out);  // Here the first argument is your target location to search while second parameter will be for printing results, if you want it null or not specified then its default behavior of passing current system's out stream won’t work as intended so we can consider any other printable object
    }  
}