import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_21240_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            // Start XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a default handler
            DefaultHandler defaultHandler = new DefaultHandler();
            reader.setContentHandler(defaultHandler);

            // Parse the XML
            parser.parse("src/main/resources/example.xml", defaultHandler);
        } catch (Exception ex) {
            System.out.println("Error parsing XML: " + ex.getMessage());
        }
    }
}