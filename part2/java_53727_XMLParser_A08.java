import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
  
public class java_53727_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String fileName = "sampleFile"; // Use your xml filename here 
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);// Disable validation to simplify the example a bit  
          
        XMLParser parser=factory.newSAXParser();   
         
       SAXHandler handler  = new SAXHandler (fileName,parser );  // create your handlers here for error handling and logging etc..     
        
     }                 
}