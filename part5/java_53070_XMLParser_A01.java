import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53070_XMLParser_A01 {  // start of code snippet    
    public static void parse(String xmlFile) throws ParserConfigurationException, SAXException{  
        String language = "en";         
        DocumentBuilderFactory factory = 
            DocumentBuilderFactory.newInstance();                  
        
        try {                 
             // Create a new document builder          
              DocumentBuilder builder=factory.newDocumentBuilder();   
              
                System.out.println("Parsing the XML file"); 
                
              // Parse the input file and create an XmlReader for it           
                        SAXParser saxParser =builder.newSAXParser( new Properties() );       
        
             MyHandler myhandler=new MyHandler();         
              
                     saxParser.parse(xmlFile,myhandler);     // Parse the input file          
                 }  catch (Exception e) {           
                  System.out.println("Error parsing XML: " +e );              return;      }   
        }}