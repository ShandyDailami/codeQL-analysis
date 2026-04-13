import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.net.URL;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
 
public class java_48610_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        URL url = new URL("http://sample.xml.org/books.xml"); // Provide your xml file here              
  
        SAXParserFactory factory = SAXParserFactory.newInstance();            
        try (SAXParser saxp = factory.newSAXParser(url.openStream(), new DefaultHandler())) {                  
            SaxContentHandler handler= new SaxContentHandler();          
    		saxp.parse( url.openStream() ,handler);   // Call your methods to handle events      }             catch (Exception e){  System.out.println("Failed: " +e );}}                 
        SAXParserFactory factory2 = null;    if ((factory2=SAXParserFactory.newInstance()) !=  null) {               try{            saxp  =   factory2 . newSAXParser(url.openStream(), handler);              } catch (Exception e){ System.out.println("Failed: " +e );}}
        SAXParsing myparser=null; if ((myparser = SaxContentHandlerFactory()) !=  null) {      try{               saxp  =   factory . newSAXParser(url.openStream(), handler);              } catch (Exception e){ System.out.println("Failed: " +e );}}
    }}  // end of class XmlExample