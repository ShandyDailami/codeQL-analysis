import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_46817_XMLParser_A01 extends DefaultHandler {    
    @Override  // This is the default behavior for SAX, no exception will be thrown on error  
    public void startElement(String uri, String localName, String qName) throws SAXException{       
       System.out.println("Start Element: " + (null == localName ? '<'+uri+ '#'+qName : localName));        
     }  // end method  
     
    @Override           
    public void characters(char[] ch, int start, int length) throws SAXException {          
       System.out.println("Character data: " + new String (ch,start,length).trim());       
     }        
}  // end class