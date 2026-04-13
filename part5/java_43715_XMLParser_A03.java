import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
 
public class java_43715_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String url = "http://example.com/test.xml"; // replace with your xml file URL here     
          
            getDataFromUrl(url); 
       }    
            
    public static void getDataFromUrl (String uri) {             
          try {                  
                SAXParserFactory saxParserFactory =   SAXParserFactory.newInstance();                 
                SAXParser saxParser =  saxParserFactory.newSAXParser(new InputSource( new URL(uri).openStream() ) ;            
                
               // Create a handler object which is going to be used by the parser      
              MyHandler myHandler = new MyHandler(); 
                 
                /* parse xml file */           
                        saxParser.parse(myHandler, null);          
                      } catch (Exception e) {  
                          System.out.println("Parsing error " +e );        return;    };      });    
         }}