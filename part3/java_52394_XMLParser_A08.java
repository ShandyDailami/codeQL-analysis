import java.io.*; // Import File I/O classes for handling files   
import javax.xml.parsers.*;//Import XML parser class java_52394_XMLParser_A08 org.w3c.dom.*; // For DOM manipulation    
import org.xml.sax.*; //For SAX parsing 

public class Main {        
 public static void main(String[] args) throws ParserConfigurationException, SAXException{         
        String fileName = "testfileA08_IntegrityFailure";  
          
      try (InputStream is = getClass().getResourceAsStream(fileName))  // Read the xml from resources      
         {           
             DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();             
                    
             DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();         
                      
             InputSource source   = new InputSource(is);   
                         
             //Parse the content of XML file          
             org.w3c.dom.Document doc =dBuilder .parse(source);  
                                 
              printElementData (doc, ""); 
         }         
     catch (IOException e) {e.printStackTrace();}       
    }}      // End main method