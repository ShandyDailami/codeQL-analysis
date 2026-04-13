import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_51744_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String url = "http://example/path_to_yourfile"; // replace with your actual URL here or file path in local system 
        
		// Create an instance of the XMLReader interface and parse a document. The parser is not required to be connected: it can run while fetching resources from network, etc..  
        SAXParserFactory spfactory = SAXParserFactory.newInstance(); //create sax factory object   
	    SAXParser sparser  =spfactory.newSAXParser(null);//creating a new parser  using the above factories     
	    
       DefaultHandler myhandler= new MyDefaultHandler() ;  
        XMLReader xreader = null;         //create an instance of xml reader for parsing through document   
          
	    System.out.println("Parsing complete in chunks:"); 	//prints to console the state changes during parsing process    
	      
	  sparser .parse(url, myhandler );//invoke startElement method while reading XML file   //start element processing continues until all content is read   
        }     
}