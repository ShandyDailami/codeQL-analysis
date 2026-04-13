import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_48906_XMLParser_A01 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{    
        String xmlFile = "/path/to/maliciousXML";  // replace with actual path of malicious XML file        
	PullParserFactory factory = PullParserFactory.newInstance();  
    ReadController controller =  factory.newReadController(xmlFile);      
    SAXParser saxParser  = factory.newSAXParser(controller);     
	saxParser.parse(controller, new MyHandler());     // parse XML file and start processing it through the handler 
	}       	
}