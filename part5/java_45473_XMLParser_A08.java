import org.xml.sax.*;
import java.util.HashSet;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
public class java_45473_XMLParser_A08 {  
    private HashSet<String> uniqueTags = new HashSet<>(); // Using a Set to avoid duplicate tag names 
    
    public void parse(XMLReader reader) throws SAXException, IOException{      
        while (reader.hasNext());     
            read(reader);        
    }  
         
    private static final String[] SECURITY_FAILURES = {"A08", "Access to"}; // Security-sensitive operations 
    
    public void startElement(String uri, String localName, String qName)      
            throws SAXException {       
           if (!isSecurityFailure(qName))          uniqueTags.add(qName);      }  
              
 private boolean isSecurityFailure (final String s){  // Checks for security failures on tag name and returns a Boolean value             return Arrays .asList ("A08_IntegrityFailed", "Access to").containsAll    (Arrays .asList(s.split("_"))); }         
      
public static void main(String[] args) throws ParserConfigurationException, SAXException {   //Main method  parse XML file here     UniqueTagPrinter printer = new         UniqueTagPrinter();           FileInputStream in=new        FileInputStream("/path/to your xmlfile.xml");    SAXParserFactory factory=SAXParserFactory .newInstance ();     
          SAXParser parser=factory.newSAXParser () ;     ParserHandler handler = new         PrinterHandler(printer)  ;       reader  =parser.getXMLReader();reader .setContentHandler   (handler );             readernextElement    ("in" , in ); }          
}`