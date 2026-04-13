import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45715_XMLParser_A08 extends DefaultHandler {  
    public boolean hasElement = false;    
      
    // This method will be called when an element starts 
    @Override     
    public void startElement(String uri, String localName, String qName) throws SAXException{         
        if (qName.equals("element")) {             
            hasElement = true;        
        }          
   }     //end of method      
}