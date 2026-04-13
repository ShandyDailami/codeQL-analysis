import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_51547_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "/path/to/yourXMLfile";  // replace with your XML file location         
          
        DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  
              
        /* Creating a new document builder */   
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();    
        
        System.out.println("Parsing the XML file");      // print statement for testing purposes 
          
       try (FileInputStream fis = new FileInputStream(xmlFile)) {   /* replace with your xml input stream */   
              Document doc =  dBuilder.parse(fis);    
              
        } catch (Exception e) {         System.out.println("Parsing failed");          // print error message  if fails to parse the XML file      
            return;   /* exit program in case of parsing failure */     
             }}   
              finally{/* Close connections and clean up resources here, but it's not necessary for this example*/} ;        System.out.println("Parsing Successful");  }     // end main method         
       };   /* End class XmlParserExample         ''''' */      '