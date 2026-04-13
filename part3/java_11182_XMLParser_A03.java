import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_11182_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a new SAXParser
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (Exception e) {
            System.out.println("Error creating SAXParser: " + e.getMessage());
            return;
        }

        // Create a new DefaultHandler
        DefaultHandler handler = new DefaultHandler();

        // Set the DefaultHandler for the XMLReader
        reader.setContentHandler(handler);

        // Set the URL for the XMLReader
        reader.setErrorHandler(handler);

        // Parse the XML file
        try {
            reader.parse("input.xml"); // Replace with the path to your XML file
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
            return;
        }
    }
}