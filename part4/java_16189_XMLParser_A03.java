import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReader.UncaughtExceptionHandler;

public class java_16189_XMLParser_A03 {

    // SAX parser
    private static final SAXParserFactory factory = SAXParserFactory.newInstance();

    public static void main(String[] args) {
        // Start by catching any SAX exception
        factory.setValidating(false);
        factory.setNamespaceAware(false);
        UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
            public void uncaughtException(SAXException e) {
                System.err.println("SAXException detected: " + e);
            }
        };
        XMLReader reader = factory.newSAXReader(handler);

        try {
            reader.setContentHandler(new ContentHandler());
            reader.parse(LegacyXMLParser.class.getResourceAsStream("legacy.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ContentHandler for SAX events
    static class ContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Simulate security-sensitive operation
            String injection = attributes.getValue("injection");
            if (injection != null) {
                System.out.println("Security warning: Suspected injection in element " + qName);
            }
        }
    }
}