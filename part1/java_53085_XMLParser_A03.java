import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_53085_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        // Load the xml document by reading a file            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
           XmlReader reader=dBuilder .getXmlReader( );    
       try {   
          readXMLFile("/Users/username/Documents/testfile_10MB-xml");         // replace with your file path   }      catch (IOException e)            {              System.out.println("Error in reading the XML File: " + e);  return; }}     finally{ reader .close();}}