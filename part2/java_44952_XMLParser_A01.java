import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_44952_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
        
        // Using the factory's newDocumentBuilder method to create a DOM parser with any Builder implementation available:    
          XMLReader xmlReader =  (XMLReader)(dbFactory).newSAXParser().getXMLReader();   
  
           String file = "example_file.xml"; 
     
         // Using the factory's newDocumentBuilder method to create a DOM parser with any Builder implementation available:    
          XMLHandler handler  = new XMLHandler( );      
        xmlReader.setContentHandler(handler);    }  
}                 
class XMLHandler extends DefaultHandler {            public void startElement (String uri, String localName , 
                String qName, Attributes attributes) throws SAXException{     System.out . println("Start Element : " +qName );}}           class XmlData implements DataSource   // Here we'll implement the methods required for data sourcing}                 }         `