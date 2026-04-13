import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53014_XMLParser_A08 extends DefaultHandler {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "src/main/resources/books.xml"; // Path to your XML file         
	XmlSaxParser parser= new XmlSaxParser();  
		    
    try {            
            SAXParserFactory factory = SAXParserFactory.newInstance();        
	    SAXParser saxParser =  factory.newSAXParser();     
      
        // Parse the xml file into DOM tree         
	saxParser.parse(xmlFile, parser); 
    } catch (IOException e) {    	  
            System.out.println("Error reading XML File: " + e);        
	}		              
}            
@Override          
public void startElement(String uri, String localName, String qName, Attributes attributes){                 	       
System.out.print("\nBook Information : ");             	  	   	 			   				     }       					     	      @SuppressWarnings("unused")  private static class BookHandler extends DefaultHandler {		       ... (Rest of the code)         	}                    }}`;