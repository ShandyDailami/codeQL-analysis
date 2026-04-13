import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48506_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        // Create an instance of the custom handler (which implements DefaultHandler interface in java-based xml parsing). 
        MyContentHandler contentHandler = new MyContentHandler();
        
	// Initialize and parse a XML document. Here we are using "input.txt" which is our test input file for this example: 'bookstore_sample10kB.xml'. Replace with your actual xml files or any other source of data you want to read from the same way in future too!
        SAXParserFactory spf = SAXParserFactory.newInstance();   // Create a new instance of XML parser factory 
	SAXParser saxParser=spf.newSAXParser(true);     			// Creating an object for xml parsing with above settings (for true - it means that the handler should be notified when each and every tag's start is encountered.)    // Parse through XML file 
	saxParser.parse("bookstore_sample10kB.xml", contentHandler);	// Passing your input source to parser  		    	        	        }       					     			             	   	 	     	}      				                           							                 fff                                                    hhh                                                                                  jjh                             dgf
}  kklkk    llll .'`!..,.dmlm.', `., ,;,,, ', ..... '....'''. ''.' '',.....,'',' '.'; ;   '''  ` ...- .... -.-;-........-.      '-._'-_.--=.--==,--_ === -- =?w