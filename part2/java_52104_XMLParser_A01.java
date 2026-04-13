import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52104_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "example_filepath";  // Replace with your file path or URL for the XML document to parse
        
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();  
            
			// Create a new parser instance using DefaultHandler class which is responsible handling start, end and element events of xml documents 
	        SAXParser saxParser=factory.newSAXParser(true);    //True to allow external connections    
	        
            MyHandler myHandler = new MyHandler();  
            
			//Parse the XML file starting from root tag (XML document's element)     			             									 
	        saxParser.parse(xmlFile,myHandler );       }    //Catch any exceptions that might occur     catch block         	                finally            if-else blocks for cleanup code                  		        System.out.println("Parsing Completed.");  	}catch (Exception e) {System.err.println ("Caught Exception: " +e);}}