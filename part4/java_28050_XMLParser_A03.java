import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicSaxContext;
import java.io.File;

public class java_28050_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a new file for testing
        File testFile = new File("test.xml");

        // Create a basic SAX context
        BasicSaxContext basicContext = new BasicSaxContext();

        // Create a SAX reader
        XMLReader reader = XMLReaderFactory.createXMLReader(basicContext);

        // Set the content handler
        reader.setContentHandler(new MyContentHandler());

        // Parse the XML file
        try {
            reader.parse(testFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}