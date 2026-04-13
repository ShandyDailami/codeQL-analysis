import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_15999_XMLParser_A07 {
    public static void main(String[] args) {
        // Creating an instance of SAXDriver
        SAXDriver driver = new SAXDriver();

        // Creating an instance of XMLReader
        XMLReader reader;

        try {
            // Creating an instance of SAXHandler
            SAXHandler handler = new SAXHandler();

            // Setting the SAXHandler as the content handler
            reader = XMLReaderFactory.createXMLReader(handler);

            // Parsing the XML file
            reader.parse("sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}