import java.io.*; // For File I/O operations only in Java Standard Library (JSL)  
public class java_52581_FileScanner_A07 {  /* This is our main program that will be executed by JVM */   
 public static void main(String args[]){    
        String currentDir = new File(".").getAbsolutePath(); // Get the absolute path of this file's location.        
          try (FileScanner scanner = 
               new com.sun.nio.fs.UnixFileSystem.Walker()  /* Using 'com.sun.*', as it is standard Java and widely used */) {  
                for(DirectoryStream.Event event :       // Use a modern API Directory Stream instead of old I/O-based approach    
                    scanner.iterator())    if (event.getKind().isFile() && new File(event.getName()).getName().endsWith(".txt"))  {   /* Check for .text files */        
                        System.out.println("Found text file: " + event.getName());     // Print out the name of found filename      }                 }) ;    if (e != null) throw e;          }} )"*/