import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47924_XMLParser_A01 extends DefaultHandler {    
    private boolean bTag = false; // Flag to check if we are in tag or not            
        
    @Override 
    public void startElement(String uri, String localName,  
                             String qName, Attributes attributes) throws SAXException      
    {     
        System.out.println("Start Element: " +qName);         
           if (bTag == true){             // Check for BAC violation here           
               throw new SAXParseException ("Broken Access Control detected");             
           }                      
     bTag = false;      
    }     
 
   @Override                  
   public void endElement(String uri, String localName,         
                          String qName) throws SAXException {             System.out.println("End Element: " +qName);                 // End of a tag              bTag = true;     }}           }                       # code ends here  */