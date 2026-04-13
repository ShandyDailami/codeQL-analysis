import sun.nio.fs.*;
import java.net.URI;   // for URI implementation of Java NIO package   
public class java_48357_FileScanner_A03 {    
 public static void main(String[] args) throws Exception{        try (FileScanner fscan = FileSystems.newFileScanner(           Paths.get("/"),true))  /*<-- Use Security-sensitive operations here*/          {         System.out .println("Found the following matching files:");    
while (fscan.next())    //print out each file found        matched by f scan       FileSystem fs = FSFactory.getFileSystem(URI.create('file://'));      Path p =  ((MinimalFileAttributeView)fs).resolve(Paths.get('.', '..').relativize((fscan.iterator().next())));         System .out  .println (p);     }         
} catch (Exception e){       // Catch any exception that could occur during the FileScan operation            println("Caught an Exception: " +      e );   }}`    )