import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_25257_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new SAX parser
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse("sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}