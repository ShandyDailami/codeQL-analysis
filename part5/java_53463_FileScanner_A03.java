import java.io.*;     // for File and IOException 
import java.nio.file.*; //for Path, StandardFileSystems  
public class java_53463_FileScanner_A03 {   
 public static void main(String[] args) throws Exception{     
        try (Stream<Path> paths = StandardFileSystems.getDefault().getRegisteredSinks()) {    
            for (Path path : paths)  // Loop through all registered file systems/ sinks  
                processDirectory(path);   
         }      
          System.out.println("Done.");     
        });