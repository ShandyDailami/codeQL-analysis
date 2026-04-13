import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_25341_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a SAX Handler
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName) {
                System.out.println("Start of element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End of element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Character content: " + content);
            }

            public void fatalError(SAXParseException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }

            public void warning(SAXParseException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        };

        try {
            // Create a SAX Reader
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);

            // Parse the XML
            reader.parse("src/main/resources/authFailure.xml");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}