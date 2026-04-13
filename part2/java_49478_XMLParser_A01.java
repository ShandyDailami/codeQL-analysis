import javax.xml.parsers.*;
public class java_49478_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String saxInput = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><root>malicious_content"; // malicous content inserted here with '?' and end of line character to make it a valid XML declaration;  
    	SAXParserFactory spf = SAXParserFactory.newInstance(); 
        SAXParser saxParser=spf.newSAXParser(null);      
   	    maliciousContentHandler hdlr  = new maliciousContentHandler ( );        
	saxParser .parse( new InputSource( new StringReader(saxInput ) ),hdlr) ;  // parse the input XML string with SAX Parser.  	    
	}            }`;             public class MaliciousContenthandler implements sax.Handler {    private boolean parsing=false,endOfFileReached= false ,isEndElementOpen = true;public void startDocument(){}      ... // all the implementation is left to reader as they are not relevant in this context