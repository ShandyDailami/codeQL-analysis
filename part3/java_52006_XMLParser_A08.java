import javax.xml.parsers.*;
import org.xml.sax.*;
public class java_52006_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // create a factory object for the new Xml parser using default settings (null preferences).    
       XMLReader reader = XMLReaderFactory.createXMLReader();     
        
           String url="http://www.example.com/books.xml";  
            System.out.println("Parsing "+url);    // print out the name of source document to be parsed 
            
        SAXParser saxParser = null;      
          try {      sasaxHandler =  new mySAXHandler();     reader .setContentHandler(saxhandler ); } catch (Exception e) {}   super.init();    // call the init method of parent class           return;}  @Override public void startDocument() throws SAXException{System.out.println("start document");}       
@Override         public void endDocument ()throws     SAXException { System . out . println ("end:document" ); }      protected   Logger logger=LoggerFactory    // get an instance of a log manager and provide the required namespaces  private mySAXHandler saxhandler; @org.xml.sax       
public void startElement(String uri, String localName , String qname )throws SAXException { System . out     ( "Start: element [local name=" +      localName  + ", uri =]"+uri); }  // define our handler class to handle the events of XML document.   @org       
public void endElement(String uri, String localName ,       String qname)throws SAXException { System . out     ( "End: element [local name=" +      localName  + ",    URI =]"+uri); }  // define our handler class to handle the events of XML document.   @org       
public void characters(char [] ch, int start ,int length)throws SAXException { String s = new     String (ch,start,length); System . out      ("Characters: " +s );} }  // define our handler class to handle the events of XML document.   @org       
public void ignorableWhitespace(char [] ch , int start ,int length)throws SAXException {    String s = new     String (ch,start,length); System . out      ("Ignoring whitespaces: " +s ); } // define our handler class to handle the events of XML document.   @org       
public void warning(SAXParseException e ) throws SAXException  {} public boolean error(SAXParseException    e)throws     SAXException { return false;}}`! '