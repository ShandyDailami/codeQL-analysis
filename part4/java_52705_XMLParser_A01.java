import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52705_XMLParser_A01 { 
    public static void main(String args[]) throws ParserConfigurationException, SAXException{     
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      
        
        // Disable external stylesheet validation (A01_BrokenAccessControl related to security).         
        try { 
            String language   = "http://www.w3.org/XML/SAX/";     
                XMLReader reader = factory .newSAXParser().getXMLReader(language);        
              DefaultHandler dummy  = new DefaultHandler(){     public void startDocument(){}    };           // Dummy handler for error reporting      
            System.out.println("Parsing with SAX and a minimal set of handlers");         
                reader .setContentHandler (dummy );      }  catch(Exception e){         Logger logger = java.util.logging.Logger.getAnonymousLogger();           // Error handling       ...   };     finally { try{ Reader in =  new InputStreamReader(new FileInputStream("input.xml"),"utf-8");            Parser parser= factory .newSAXParser (); 
    parser.setEntityResolver((XmlEntityResolver) ) ;parser.parse(in,dummy ); } catch (Exception e){ Logger logger = java.util.logging.*;          // Error handling... };     }}