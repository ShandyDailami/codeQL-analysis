import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;

public class java_50588_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        // Loading the xml file from URL        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();         
  
        try (InputStream url = new URL("http://example/path_to_yourxmlfile").openStream()) {            
            // Parsing the xml file        
           Document doc = dBuilder.parse(url);    
 
           getElementValue(doc, "tagName");    } catch (IOException e)       {   System.out.println("Error: unable to retrieve or load XML data due" +e );}      return;}}             public static void getElementValue(Document doc, String element){        NodeList nl = doc.getElementsByTagName(element);         for (int i = 0;i <nl .getLength(); ++i) {           Element e  = (Element) nl.item(i);                System.out.println(" Value of node " +e.getTextContent());}}}