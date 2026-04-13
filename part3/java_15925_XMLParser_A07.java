import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import org.xml.sax.sax;

public class java_15925_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";

        // Create a new instance of DefaultHandler
        DefaultHandler handler = new DefaultHandler();

        try {
            // Create a new instance of XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Set the new instance of DefaultHandler as the new handler for the XMLReader
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}