import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_40025_XMLParser_A08 {

    public static void main(String[] args) {
        // Create a SAX parser
        SAXReader reader = new SAXReader();

        // Create a DefaultHandler
        DefaultHandler handler = new DefaultHandler();

        try {
            // Parse the XML file
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse("example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}