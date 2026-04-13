import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52621_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        // Create a new instance of the DefaultHandler 
        XMLReader reader = XMLReaderFactory.createXMLReader();    
        
        CustomDefaultHandler handler =  new CustomDefaultHandler() ;     
         
       /* The parse method starts parsing by calling next methods in loop, until it can not read more */  
           while (reader.hasNext()) {            
              int type = reader.getEventType();    
               switch(type)  // Checking the event-types and handling them as required...       
                      case Html.START_ELEMENT:    // Start elements, here you can handle security sensitive operations  
                          break;      
                       ...            }           return;}          };      reader = XMLReaderFactory .createXMLReader();  });     catch (ParserConfigurationException e) {e.printStackTrace( );}}};`         /* End of main method */    private static class CustomDefaultHandler extends DefaultHandler{@Override public void startElement(String uri, String localName , String qName
>startDocument(){} @ Override  public end ...; }...} //Add more methods as required to handle elements according your requirements. This will be done in the handler of SAX reader});`   */     }}  `}}};