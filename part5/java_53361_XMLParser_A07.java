import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53361_XMLParser_A07 extends DefaultHandler {  
    private boolean authFailure = false;  // flag indicating authentication failure
    
    @Override public void startDocument() throws SAXException {}
      
    @Override public void endDocument() throws SAXException {}     
        
    @Override public void startElement(String uri, String localName, String qName)  
        throws SAXException {  if (qName.equals("AuthFailure")) authFailure = true; }          
      
    // handle other elements here...    
}