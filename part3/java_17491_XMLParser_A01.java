import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_17491_XMLParser_A01 {

    public static void main(String[] args) {
        // Parse the XML file
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new BasicHandler());
            reader.parse("src/sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // BasicHandler for SAX parsing
    static class BasicHandler extends org.xml.sax.helpers.DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                throws SAXException {
            System.out.println("Start Element: " + localName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + localName);
        }

        private void printAttributes(org.xml.sax.Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQName(i) + "=" + attributes.getValue(i));
            }
        }
    }
}