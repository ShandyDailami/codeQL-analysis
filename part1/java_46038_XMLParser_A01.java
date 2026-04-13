import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_46038_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Load XML file using the default configuration (don't use external frameworks!)      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
        
        try(InputStream inputStream =  new FileInputStream("src/sample.xml")) {    // Use local file, replace with your XML path  
            Document doc = dBuilder.parse(inputStream);      
            
           // Normal processing of document    
			doc.getDocumentElement().normalize();     
               System.out.println("\nRoot Element: " + doc.getElementsByTagName("root"));    }  catch (IOException e) {e.printStackTrace();}  
        }}`;           // End of code snippet