import java.io.*; // for FileInputStream etc...
import javax.management.* ;//for JMXOperations and others..   
  
public class java_42807_FileScanner_A01 {    
       public static void main(String[] args) throws Exception  {        
            System.out.println("Starting scan...");            
              try (Stream<Path> paths = Files.walk(Paths.get("/"))){                
                    // Filter out non-directory entries         
                forEachFileMatch((file, dirnameLoopVar) ->  file instanceof File && ((File)file).isDirectory(), 20 , Path::getName);               }             System.out.println("Finished scan..."));       }}    
//end of Main class      @FunctionalInterface   interface IMatcher { boolean matches(Path path, Object loopVar );}}    // end anonymous implementation for the functioninterface}{{{}}}  */} package;/**/package a01_brokenaccesscontrol{/* Start A02 Broken Access Control.*/