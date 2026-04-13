import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_45591_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Create a new instance of the DocumentBuilderFactory    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
        
        try {      
            // Use our custom DTD validator for parsing   
             factory.setValidating(true); 
             
           XMLReader reader=factory.newSAXParser().getXMLReader();  
          ParserHandler handler = new ParserHandler();    
         reader.setContentHandler(handler);       // set our content Handler     
            String url;   
             for (int i = 0 ;i< 15;i++) {       
               if ((url=getUrl()) != null){   } else{break;}          System.out.println("Failed to load URL");         return;     }}       catch(Exception e ) {}      finally{}return false}}`    // End of main method