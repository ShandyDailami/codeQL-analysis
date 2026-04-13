import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
public class java_48438_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Create the factory for reading our Xml documents:
      	ParserFactory parserFactory = ParserFactory.newInstance();    
            try {     
                // Setup a default handler to catch any error events that occur while parsing  :   
                 DefaultHandler dh= new DefaultHandler(){          
                     boolean inElementName=false;  
                      public void startElement(String uri, String localname,      
                         String qname , Attributes attributes)    
                       throws SAXException{     
                          // Printing tag name:  (this is where you can use the security-sensitive operations as per your requirement :    e.g., print out sensitive data using log4j for A01_BrokenAccessControl):        inElementName=true;     System.out.println(localname);     
                      }  
                       public void endElement (String uri, String localname ,      
                         String qname )throws SAXException {  // When tag name is over we set it to false:   
                          if("item".equalsIgnoreCase(localname)) inElementName=false;     System.out.println("/ "+localname);      }   };       
             Source xmlfile =  parserFactory .newSAXSource( new File(  "/path/to/yourxml" ),dh );    //Here we pass our Xml file and its handler:            SAX Parser :     XMLReader reader = parserFactory.newSAXReader();      reader.setContentHandler ( dh ) ;      
             // Read the input from xml   - not really necessary if you are reading a large piece of data but will be useful for testing this in sandbox mode with small dataset:        
            } catch(IOException e) {     System.out.println("Problem parsing XML" +e);      return;  }}    // This is where the error handling starts (to print stack trace):        SAX Parser :   try{ reader = parserFactory .newSAXReader();      
            } catch(Exception e){System.out.println ("Error processing xml: "+e) ;     System.exit(-1);}}  // This is the end of error handling block, it stops when an exception occurs in SAX parsing      system    }}