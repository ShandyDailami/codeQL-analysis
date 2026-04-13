import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45318_XMLParser_A01 {  
    public static void parse(String file) throws ParserConfigurationException, SAXException{ 
        // Create the factory for reading from an external stream of data (XML-file in this case).
    	SAXParserFactory spf = SAXParserFactory.newInstance();         
        
      /* We're going to use a DefaultHandler which does nothing on "element" and   */ 
      	/* only log the content that matches our query, otherwise we would print out an enormous xml-file in console...*/   
        DefaultHandler dh = new DefaultHandler(){             
            @Override             public void startElement(String uri , String localName,     String qName, Attributes attributes) throws SAXException{                  // Start a match                    }                     });      */          }}  };           **End of XML Parser**