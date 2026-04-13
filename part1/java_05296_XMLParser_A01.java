import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_05296_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParser();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void SAXParser() throws SAXException {
        // Create a SAX parser
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Set the content handler
        reader.setContentHandler(new XMLHandler());

        // Parse the XML file
        reader.parse(new File("src/main/resources/example.xml"));
    }
}