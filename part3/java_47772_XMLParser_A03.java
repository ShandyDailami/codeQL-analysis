import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47772_XMLParser_A03 extends DefaultHandler {    
    private String thisElement = ""; // Which element's data is currently being processed? 
  
    public void startDocument() throws SAXException {        
        System.out.println("Start of XML document");      }      
          
          @Override            
            public void endElement(String uri, String localname , String qName)                  
              throws SAXException{                    
                    thisElement = "";                     
                  // Ending element detection and operation here                       
                System.out.println("End of " +qName);    }        @Override            
            public void startElement(String uri, String localname , 
                                       String qName) throws SAXException {                
                    thisElement = qName;               // Starting element detection and operation here                      }}