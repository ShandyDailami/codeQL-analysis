import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45515_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String file = "src/data_injection.txt"; // replace with your own XML source or local resource            
     	SAXParserFactory factory  = SAXParserFactory.newInstance();           
	      SAXParser parser   =   factory . newSAXParser();   		    			 	       									       	   								      						        
	  MyHandler handler = new MyHandler ();           // create a Handler for the XMLDocument	               							     	// to handle individual elements and attributes of one element.                         	      }                                public class SAXPractice {public static void main(String[] args) throws ParserConfigurationException,