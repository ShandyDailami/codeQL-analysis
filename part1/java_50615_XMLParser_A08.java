import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_50615_XMLParser_A08 {    
    public static void main(String[] args) throws Exception{        
        // Create an instance of the XML reader            
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();                
        DocumentBuilder builder=factory.newDocumentBuilder(); 
      
      try (InputStream is  = new FileInputStream("sampleFileLocation")) {             
            Document doc =  builder.parse(is);         
         // Continue with the parsing and security sensitive operations...            
                }   catch (ParserConfigurationException | SAXException e)    {}     finally  {}}          
}