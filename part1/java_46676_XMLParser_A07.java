import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_46676_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Create the factory with default parameters for parsing XML document on disk or from network stream (default is false).      
	SAXParserFactory saxFactory = SAXParserFactory.newInstance();  
	// Get the SAX parser   
	SAXParser saxParser = saxFactory.newSAXParser(null);  // Default Handler as we don't need to do anything special with parsed data    
        String inputFile="A07_AuthFailure.xml";// Provide your xml file here  
	// Create the handler and set it in parser   
	MyHandler myhandler = new MyHandler();  // Default Handler as we don't need to do anything special with parsed data    
        saxParser.parse(inputFile,myhandler);     
	}      
}        
// Define a SAX XML parsing handler  
class MyHandler extends DefaultHandler {    public void startElement (String uri , String localName  , String qName , Attributes attributes) throws SAXException{     // Start of element handling code here. This method will be called for each opening tag in the xml document starting with this name} }     `