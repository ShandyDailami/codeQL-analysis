import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52169_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url="file:path_to/yourXMLFile";  // replace with your XML file path     
         
         getDataFromXmlFile(url);      
    }          
   private static void getDataFromXmlFile (String input) throws ParserConfigurationException, SAXException {    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();     
        
        // parse the content of XML file      
        Document doc=dBuilder.parseURL(input);   
         
        System.out.println("Root element : " +doc.getElements().getNamedItem("root"));  
     } 
}