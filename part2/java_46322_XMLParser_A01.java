import javax.security.auth.*;
import java.io.File;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
...
public class java_46322_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Check if user is authenticated to read from the file system location:        
       try {         
           new java.security.SecurityManager().getSubject().authenticate("file:///inputFilePath");     
            System.out.println("\nUser has permission!");    } 
        catch (UnavailableException e)     // Not authenticated!            
         {   System.err.println ("\nYou need to be logged in and have proper permissions.");}         
                ...