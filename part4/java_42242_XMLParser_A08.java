import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_42242_XMLParser_A08 {    
    public static void parse(String file) throws ParserConfigurationException, SAXException{            
            SAXParserFactory factory = SAXParserFactory.newInstance();          // step 1        
            SAXParser parser = factory.newSAXParser();                      // Step2          
              
            MyHandler myhandler= new MyHandler ();                          // create a handler and pass to the saxparser     
            
              parser.parse(file,myhandler );                               // step 3      
        }    
}