import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;

public class java_52025_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    
        // Load the XML document into a Document object 
        URL url = new URL("http://example/sample.xml");      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
        org.w3c.dom.Document doc=dBuilder.parse(url.openStream());    // Load the XML into a DOM tree 
      
        // Now you can use this 'doc' object for parsing your data as required, and to manipulate it using JAXP API  
     }     
}