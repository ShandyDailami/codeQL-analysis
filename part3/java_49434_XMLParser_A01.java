import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import the following classes to handle exceptions    IOException and XMLException    
public class java_49434_XMLParser_A01 {     
 public static void main(String[] args) throws ParserConfigurationException, SAXException  ,IOException{       
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
       DocumentBuilder builder  =factory.newDocumentBuilder();         
   // Reading the XML file    
    try (InputStream stream = SimpleXMLParser.class.getResourceAsStream("/data/sample-feed.xml")) {          
        Document doc =  builder.parse(stream);             
      printElement("Root",doc); } 
       catch (Exception e)   // Catch and handle exceptions     while parsing the XML file         
    {}                 return;            }}        `