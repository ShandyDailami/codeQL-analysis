import java.io.*;
import org.xml.parsers.*;
import javax.security.auth.callback.*;
import javax.xml.parsers.*;
public class java_42600_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{    
        String url = "http://example/test-file"; // Replace with your URL here        
		// Username and password for the server where file is located, you can remove this if not required. 
		
	    SAXParserFactory saxpf=SAXParserFactory.newInstance();  
        SAXParser sparser =saxpf.newSAXParser();   
          
         // Setting Callback Handler for authentication failure (A07_AuthFailure).      
          AuthHandler authhandler =  new AuthHandler(){            
            public void handle(String arg0, String arg1 , Principal arg2){               
               throw new AuthFailureException("Authentication failed");  }              };  
          
        sparser.setProperty("javax.xml.parsers.SAXParserFactory", "http://www.ibm.com/xml/parser") ;     // This is the factory used to create a SAX parser   
	sparser .parse(new InputSource(url),authhandler);   }  , new ContentHandler(){        public void startElement (String uri, String localName,      String qName, Attributes attributes) throws SAXException {}         
public void endElement(String uri, String localName,     String qName)throws SAXException{}         @Override       public void characters(char[] ch, int start,int length )throws SAXException{ } });   };    sparser.setProperty("http://xml.com/sax","javax.xml.parsers.SAXParserFactory");