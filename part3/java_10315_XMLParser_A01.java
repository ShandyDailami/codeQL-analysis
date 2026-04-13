import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;

public class java_10315_XMLParser_A01 {

    public void parse(String fileName) {
        DefaultHandler handler = new DefaultHandler() {

            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("Start of element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            public void fatalError(SAXException e) throws SAXException {
                System.out.println("Fatal error: " + e.getMessage());
            }

            public void warning(SAXException e) throws SAXException {
                System.out.println("Warning: " + e.getMessage());
            }

            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Start of prefix mapping: " + prefix + " - " + uri);
            }

            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End of prefix mapping: " + prefix);
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            reader.setEntityResolver(null); // No need for security sensitive operations
            reader.parse(fileName);
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MyXMLParser().parse("broken_access_control.xml");
    }
}