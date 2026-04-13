import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.handlers.DefaultHandler;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.xmlreader.XMLResourceLoader;

public class java_18388_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";  // Assuming the XML file is in the project resources
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String xmlFile) {
        // Create a new XMLReader
        XMLReader reader = createReader(xmlFile);

        // Create a new handler
        DefaultHandler handler = new DefaultHandler();

        // Set the handler for validation
        reader.setContentHandler(handler);

        // Parse the XML
        try {
            reader.parse("");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static XMLReader createReader(String file) {
        EntityResolver entityResolver = new EntityResolver() {
            public boolean isSystemEntity(String arg0) {
                return false;
            }

            public InputSource resolveEntity(String arg0) throws SAXException {
                return new InputSource(new StringReader(arg0));
            }
        };
        XMLReaderFactory.newInstance().setEntityResolver(entityResolver);

        XMLReader reader = XMLReaderFactory.newInstance().newSAXReader();
        reader.setEntityResolver(entityResolver);
        return reader;
    }
}