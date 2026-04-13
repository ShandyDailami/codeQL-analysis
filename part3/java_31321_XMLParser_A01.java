import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_31321_XMLParser_A01 {
    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            public void error(SAXParseException e) {
                System.out.println("Error: " + e.getMessage());
            }

            public void fatalError(SAXParseException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }

            public void warning(SAXParseException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("test.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}