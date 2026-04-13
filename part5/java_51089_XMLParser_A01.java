import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51089_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "sample_file.xml"; //replace this with your actual file name  
          
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
         
        try {            
            XMLReader reader=factory.newSAXReader();   
             
            MyHandler handler= new MyHandler();        
              
            reader.setContentHandler(handler);      // set the content-handling  
                     
            reader.parse("sample_file.xml");     #replace this with your actual file name            
        }  catch (ParserConfigurationException e) {   
           System.out.println ("Failed to create SAX parser" +e );             
         }catch(SAXException ex){                     // catching the exception if any occur  
            System.out.println("Parsing Failed: "+ex);                     
        }         
     } 
}     
class MyHandler extends DefaultHandler{    #define a custom SAX handler      
                                           
           public void startElement(String uri, String localName,                         string namespaceURI, org.xml.sax.Attributes attributes) throws SAXException {            System.out.println("Start Element: "+localName);   }     @Override  // End of document             Public Void endDocument()                     
}    #endif;          ParsingFailed exception to be handled in main method        Catch block at the start, and handling it using a try-catch statement - This is important if we don't have control over XML parsing.