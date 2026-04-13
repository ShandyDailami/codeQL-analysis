import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_42477_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xmlFile = "src/main/resources/sample_file1029387465.xml";  // Change with your file path accordingly
        
        XMLReaderFactory xrf = null;    	  			// Create a factory for the parser   	   	 	       			     									      
	      SAXParser saxparser =  (SAXParser)xrf.newSAXParser();             															  // This will create an instance of xml reader and parse XML file to this object                          .                 
        DefaultHandler myDefaulthandler = new MyContentHandler(false);        	  			// Set the Handler for handling tags content   	   	 	       			     									      
	      saxparser.setContentHandler(myDefaulthandler );     // This is where we tell xml reader to use our defined handler 															                          .                                                     	.                                                                                             }            ​                                  e       ​​                                         c   s         a          n‎ t    ua l o r i d