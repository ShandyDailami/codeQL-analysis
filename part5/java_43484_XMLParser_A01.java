import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_43484_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Setup the parser configuration and create a new instance of it:
        String language = "en"; 	// Language used in xml document (used for namespaces). Default is english. Could be any supported or not-supported namespace by your XML schema; if unset/null, then default will take place - which means no checking against the predefined list of allowed locales
        boolean strict = false ; 	// If set to true throws exception when too many tags are found (default is: False). Could be any supported or not-supported namespace by your XML schema; if unset/null, then default will take place - which means no checking against the predefined list of allowed modes
        String encoding = "UTF-8"; // Encoding used in xml document. Defaults to UTF 16 without BOM (default is: English). Could be any supported or not-supported namespace by your XML schema; if unset/null, then default will take place - which means no checking against the predefined list of allowed encodings
        
        SAXParserFactory factory = SAXParserFactory.newInstance();  // Create a new instance of our parser and set it up with all options: namespace processing mode etc...  	    
	    XMLReader reader;                                          	// Declare an xmlreader variable to hold reference towards the parsers' result, which can then be manipulated using methods provided by SAX.      			 		        									     	 														    // Setup factory with all options and create a new parser instance:
        try { reader = factory.newSAXParser( null , language ); } catch ( ParserConfigurationException e ){e.printStackTrace();}		// Create our SAXparser, setting error handling to 'throws' exception for more control over how errors are handled  									     		     // End of setup:
        
        MyHandler handler = new MyHandler() ; 	   			   	     	       	 								         ​      						                                                  .                             The parser will now call the methods within our handlers.                    		// Here we're passing a reference to an instance that implements SAXhandler and sets it up so all data is ready for processing:
        reader.setContentHandler( handler ) ; 		   	     	       	 	   									       // This tells parser where content should go (MySAXXMLReader):                                                                                                       		.                             The main event handling loop, here the parsers takes over and waits until done .          			     } catch ( SAXException e) {e.printStackTrace();}
    }} 									     		          // end of program : End your xml file by sending a close tag: </dataset> to stop all data processing, the parser then clean up resources like stream etc and finish .  			     } catch ( IOException i ){i.printStackTrace() ;}}}}}