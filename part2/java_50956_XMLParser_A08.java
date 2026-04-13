import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_50956_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Step-1 & step2: Initialize the XMLReader and configure it using a W3C DocumentBuilderFactory which is not externalized in this example. This ensures correct parsing with security warnings turned off by setting system property "org.w3c.dom.ElementTreeScopeSupport" to false
        System.setProperty("org.xml.sax.parser.url","http://xmlparserv2.sourceforge.net/");  // Disable SAX parser warning (A08_IntegrityFailure) by setting a custom URL for DocumentBuilderFactory  
        
        File inputFile = new File("/path-to-your-file/input.xml");   
          
		//Step3: Create an instance of the XMLReader and parse through our xml file – here we use SAXParser as it's a more efficient approach compared to DOM or StAX parsing methods in this example  
        SAXParserFactory factory = SAXParserFactory.newInstance();   
		//Create parser from Factory    
        SAXParser saxParser=factory.newSAXParser(null);  //no namespace prefix, use default ones if any     
          
        
	saxParser.setEventHandler( new MyContentHandler() );   //MyContenthandler is a custom class that implements the content handler of our xml file   
		//parse Xmlfile using parse method    
        saxParser.parse(inputFile,null);  }            
}     
class MyContentHandler extends DefaultHandler {           public void startElement (String uri , String localName   , String qName, Attributes attributes) throws SAXException    {}            //override the methods from default handler to perform our security sensitive operations                     @Override     protected void endElement(String uri,  String localName, String qName )throws SAXException { }       
@Override      public void characters (char [] ch, int start ,int length) throws SAXException   {}           //override the methods from default handler to perform our security sensitive operations                     @Override}    };