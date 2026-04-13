import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48080_XMLParser_A01 extends DefaultHandler {
    public static void parse(String file) throws ParserConfigurationException, SAXException{ 
        XMLReader reader = XMLReaderFactory.createXMLReader();   //creating a new instance of the xmlreader using factory methods to create an object for handling read operation in any order via constructors as per requirement      
        
        try {            
            File inputFile = new File(file); 
                 
            reader.setContentHandler(new XmlParserSAX()); //setting a content handler on the xmlreader  
              
              System.out.println("Parsing complete in SAX mode");   
          } finally {            
                reader.close();     
        }}