import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_51529_XMLParser_A03 extends DefaultHandler {     // Define the SAX parser here, using default handler methods provided by sax libraries in java standard library (org xml) 
    private boolean bName = false;               // Indicator for start of name element's content  
    private boolean bAge  = false;                // Indicator for age attribute within a Person tag     
    
    public void startElement(String uri, String localName, String qName) {      	// Start event handler methods.  This method will be called when an XML element starts - ie., it encounters the name of any new child node at this depth in your document tree (i.e a tag here).
        if (qName.equalsIgnoreCase ("person"))     // If we're on 'Person', set flag to true  for attribute or content  
            bAge = false;                         
         else if( qName.equalsIgnoreCase("name") )   	// Similar comparison as above, differentiating between name and person data fields     	
             bName=false ;    		                   // Reset the flags          			                    									 	    }  						                                 	}      								                                                                                                                     	f                              n          ]]>'`''