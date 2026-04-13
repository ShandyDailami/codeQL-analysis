import org.apache.tika.Tika;
import java.io.*;
  
public class java_51143_XMLParser_A01 {    
    public static void main(String[] args) throws IOException{       
           Tika tika = new Tika();        
            try (InputStream inputStream = 
                getClass().getResourceAsStream("/path_to/yourfile"))  // provide your file path here.         
             {                
               String contentType = tika.detect(inputStream);  
              System.out.println("Detected content type: " + contentType );     
                if (contentType != null &&      
                    ((contentType.indexOf("text/") == 0) ||         // security-sensitive operation 1       
                     (contentType.equalsIgnoreCase("application/x-rss+xml")) ||  //security sensitive op2  
                      contentType.startsWith("image/"))) {                  // Security Sensitive Operation3    /* Create a new BufferedReader for the InputStream */           
                    System.out.println(tika.parse(inputStream));       } else{                    
                throw new IOException();                               }} catch (Exception e)  {}     finally{}        };  
}