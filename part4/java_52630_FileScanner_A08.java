import javax.xml.*;
import org.w3c.dom.*;
import java.io.*;   // Import FileInputStream and InputStreamReader classes   
public class java_52630_FileScanner_A08 {    
 public static void main(String[] args) throws Exception{       
         String directoryPath = "/path/to/directory";  /* Change this to your own path */     
          try (FileScanner fileScanner =  new com.sun.org.apache.xerces.internal.jaxp.impl.PSVIStreamScanner(new FileInputStream("filename"))) {        // Use Apache's Xerces for JAXP implementation      
           System.out.println("\n Scanning directory: " + directoryPath);        
            while (fileScanner.nextToken() != StreamScanner.$_EOF){             
                switch(fileScanner.getEventType()) {                 
                    case 1 : // tokenize/scan a file     
                        System.out.println("File: " + ((XmlDocument)fileScanner).getDocURL());          break;            
                         default://default          
                            }   
                             });            }} catch (Exception e){       /* Exceptions handling */ 
                    // Your exception management here...         };        ExceptionUtilities.*; printlnEx(e);}}     `