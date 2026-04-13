import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
 
public class java_45465_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{  
        String inputfile = "inputFile"; // your xml file path here    
          
            File inputFile = new File(inputfile);        
             
                SAXParserFactory saxParserFactory = 
                    SAXParserFactory.newInstance();            
                 
               SAXParser saxParser  =  
                   saxParserFactory.newSAXParser(null, true);  // factory enabling us to use DOM parser     
                
            MyHandler myHandler = new MyHandler ( );         
             
           saxParser .parse(inputFile ,myHandler ) ;      
    }    
}