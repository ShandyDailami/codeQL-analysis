import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import org.xml.sax.*;
import java.io.*;
public class java_46671_XMLParser_A08 implements ContentHandler {   //Content Handler is an interface in SAX parser library, it'll handle the XML Document by reading and processing its elements one-by-one 
    public void startDocument() throws SAXException {}      
    
    @Override          
    public void endElement(String uri, String localName, String qName)   //called when a tag is closed. Arguments are URI of the namespace (if any), name if this element was declared in XML schema and its qualified Local Name  here we ignore both but they will be used to decide which handler methods get called for specific elements
    { System.out.println("End Element: " + qName); }   //endElement is a method of ContentHandler interface that gets invoked whenever an end element (xml tag) occurs in the document, and startDocument() when it starts parsing  this will print out each closing tags one by-one
    
    public void startPrefixMapping(String prefix, String uri) {}       //called if there are XML namespaces declared within xml file. But for us we don't need to use these here as per instruction and all our handlers in SAX parser library will only be handling end of element tags instead – just printing them
    public void characters(char[] ch, int start, int length) {}       //called when the text inside an XML Element is found. Here we don't need to use this as per requirement and all our handlers in SAX parser library will only be handling end of element tags instead – just printing them
    public void fatalError(String error) throws SAXException { System.out.println("Fatal Error: " +error); }       //called when an internal parsing error happens, e.g a memory issue or otherwise invalid XML document   here we ignore as per requirement and all our handlers in the sax parser library will only be handling end of element tags instead – just printing them
    public void startElement(String uri, String localName, String qName, Attributes attributes) { System.out.println("Start Element: " +qName); }       //called when a tag is started ie <element> in XML document this will print out each opening tags one by-one 
    public void endPrefixMapping(String prefix) {}         
    
}  
public class Main {           
      static String xmlFile="sample.xml";          
       @SuppressWarnings("deprecation")             //This method is deprecated, use the startElement() instead – it's called when a tag starts in XML Document and we want to do something specific with this event using SAX parser library   here I am just printing out each opening tags one by-one.
       public static void main(String[] args) throws ParserConfigurationException, IOException {             System.out.println("Parsing xml file " +xmlFile);            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          SAXParser saxp = dbFactory.newSAXParser();             
      //   File inputFile= new File(args[0]);           String command;             CommandLineParser parser = 
       Newer in java 9, there is no such thing as older and the difference between them can be found at https://docs.oracle.com/en/java/javase/12/docs/jdk-ui/xmlsyntaxparser.html#differences              //The documentation for this section was removed due to space constraints 
       saxp.parse(new File(args[0]), MyXmlHandler);            System.out.println("Finished parsing " + xmlFile ); }          };   End of Main Java Program    I hope that helps! Let me know if you have any more questions or need further clarification on this one