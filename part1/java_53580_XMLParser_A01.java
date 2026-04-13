import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_53580_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();         
        
        // Parse the xml file          
        try (InputStream is = new FileInputStream("sampleFile.xml")) {            
            Document doc = dBuilder.parse(is);              
 
              System.out.println("\n XML content loaded.\n");   
  
                getChildNodesInfo(doc, null );     // This will print all children and grandchildren...      
        }         
         catch (SAXException e) {                  
            LoggerFactory.getLogger("XMLExample").error("Parsing failed: " + e);           return; 
                 
             System.out.println("\n Parsed XML content:\n");   // Prints all the tags from xml file        }    
    catch (Exception ex) {                  
         LoggerFactory.getLogger(XMLExample.class).error("Error parsing: " + e);       return;  }}