import java.io.*; // Import required classes from package  
import java.nio.file.*; // Package for handling files and paths in JDK10+ onwards 

public class java_53419_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
         Path startingPath = Paths.get("C:\\Users");// Change it to your initial directory   // You can use the current user's home folder if you want         
             Files.walkFileTree(startingPath, new SimpleFileVisitor<Path>(){   
                 @Override  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {    
                     String name = file.getFileName().toString();       // Get the filename only     
                      if (name.endsWith(".txt")){                        // Check for text files       
                           System.out.println("Found a txt File: " +file);  }           return super.visitFile(file, attrs) ;   }}                 })              };});    });}}}}}`; Note that this example does not include any security-sensitive operations per your request (like using the Scanner class for user input), and is rather a simple file scanning demonstration to get you started with Java's standard library.