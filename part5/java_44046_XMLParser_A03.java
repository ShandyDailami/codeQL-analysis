import org.w3c.dom.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
  
public class java_44046_XMLParser_A03 { 
    public static void main(String[] args) throws Exception{    
        SAXParserFactory factory = SAXParserFactory.newInstance();        
        try (SAXParser saxParser = factory.newSAXParser()) {                
            File inputFile  = new File("inputfile");  // replace with your XML file path                    
             MyContentHandler myHandler= new MyContentHandler();  
             
             saxParser.parse(inputFile,myHandler);                 
         }    
    }     
}