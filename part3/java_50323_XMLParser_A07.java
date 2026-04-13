import java.io.*;
import javax.xml.parsers.*; // Import Parser & SAX API interfaces and classes in a Java SE platform, such as XML APIs for parsing data using DOM(DOM parser), Xerces (XML processor framework by Sun Microsystem) – version supported from JDK1.4 onwards
import org.xml.sax.*; //SAX2 interface to parse an XML document and construct a Document Object Model in memory, that can be queried/modified using DOM methods  
public class java_50323_XMLParser_A07 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{      
         // Create the factory object – used for handling content.         
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
            
        /* A new instance of Xerces2 XML Reader with DTD validation turned off (optional) */   
           Parser parser=dbFactory.newDocumentBuilder(new org.xml.sax.InputSource(new StringReader("")));   //with no dtd validated — optional     
         /* Set Document Handler for SAX parsing, Parse the XML document in a loop until there are not more elements to read */        parser .setContentHandler( new MyContentHandler() );    
            
    }      
}                private static class MyContentHandler extends DefaultHandler { //SAX2 Content handler – an implementation of SAX API for handling Document. Override the methods in this interface and provide your own logic to parse data using DOM*/      @Override public void startDocument(String uri, String localName, String version) throws SAXException{ System.out.println("XML Start: " +localName); } 
    //... Similarly define all other handlers (endElement(), characters()) and provide your own logic..} });   /* A new instance of Xerces2 XML Reader with DTD validation turned off */      parser = dbFactory .newDocumentBuilder( );     p.setContentHandler((org.xml.sax.ContentHandler)parser); 
    } @Override public void startElement (String uri, String localName , int line_number ) throws SAXException{ //SAX2 Content handler - an implementation of XML reader in Java */ System . out . println ("Start Element : " +localName+" on Line: "+line _ number); } 
    @Override public void endElement (String uri, String localName , int line_number ) throws SAXException{ //SAX2 Content handler - an implementation of XML reader in Java */ System . out . println ("End Element : " +localName+" on Line: "+line _ number); } 
    @Override public void characters (char [] ch,int start, int length) throws SAXException{ //SAX2 Content handler - an implementation of XML reader in Java */ System.out . println ("Characters : " + new String(ch ,start ,length));}   };       }