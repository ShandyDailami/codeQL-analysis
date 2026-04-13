import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_35116_XMLParser_A07 {
    public static void main(String[] args) {
        // Creating a SAX Handler
        SAXHandler handler = new SAXHandler() {
            public void startElement(String uri, String localName, String qName,
                    org.xml.sax.Attributes attributes) throws SAXException {
                // Do nothing
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                // Do nothing
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                // Do nothing
            }
        };

        // Creating a SAX Reader
        XMLReader reader = XMLReaderFactory.createXMLReader(handler);

        // Parsing the XML
        try {
            reader.parse("src/myfile.xml"); // Replace with your xml file path
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}