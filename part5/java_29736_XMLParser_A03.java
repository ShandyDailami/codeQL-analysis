import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.BasicHandler;

public class java_29736_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a SAX parser
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Set the parser's content handler
        reader.setContentHandler(new BasicHandler() {
            public void startElement(String uri, String localName, String qName,
                org.xml.sax.Attributes attributes) throws SAXException {
                // Do nothing: this is a secure operation, doesn't do anything harmful
            }
        });

        // Parse the XML
        try {
            reader.parse("test.xml"); // replace with your XML file
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}