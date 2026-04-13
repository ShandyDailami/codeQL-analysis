import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
 
public class java_52698_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{    
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser(true);     
        
       // Create a new handler object, which will be called when events occur: 
	DefaultHandler dh = new DefaultHandler();  
            
	// Load the XML file and parse it with our custom Handler class         
        parser.parse("sampleFilePath",dh );    }    
}