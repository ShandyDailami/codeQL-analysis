import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_43105_XMLParser_A07 extends DefaultHandler {   // Define a custom handler – not mandatory, but useful for error detection and logging   
     boolean bAuthFailure = false;                   // flag to check Auth Failure     
      
     @Override                                           public void startElement(String uri , String localName ,         
         String qName , Attributes attributes)            throws SAXException  {  
        if (qName.equalsIgnoreCase("auth")){               // Check for 'Auth' tag inside XML   
             bAuthFailure = true;                         // Set flag to TRUE, indicating Auth Failure has occurred     
         }                                             else                                                      void endElement(String uri , String localname  .   characters (char[] ch) throws SAXException {     if(!bAuthFailure){                    System.outprintln("Warning: No 'auth' tag found in the XML!");                     bAuthoFailed=true;}}}}}