import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_18070_XMLParser_A01 {
    public static void main(String[] args) {
        // Create a new SAXReader
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Create a new DefaultHandler
        DefaultHandler handler = new DefaultHandler();

        // Set the handler for the SAXReader
        reader.setContentHandler(handler);

        // Parse the XML data
        try {
            reader.parse("your_xml_data_file.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}