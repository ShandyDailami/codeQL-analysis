import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.Implementation;

public class java_01088_XMLParser_A08 {

    public static void main(String[] args) {
        // Create a new instance of the implementation
        Implementation implementation = new Implementation();

        // Create a new instance of the reader
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // Set the content handler
        reader.setContentHandler(implementation);

        // Parse the XML file
        try {
            reader.parse("resources/sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}