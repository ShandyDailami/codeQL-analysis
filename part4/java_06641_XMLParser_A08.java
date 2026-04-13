import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;

public class java_06641_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new SecureContentHandler());
            reader.parse("sample.xml"); // replace with your file
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class SecureContentHandler implements org.xml.sax.ContentHandler {

        @Override
        public void startDocument() throws SAXException {
            // Do nothing. This method is empty in this example.
        }

        @Override
        public void endDocument() throws SAXException {
            // Do nothing. This method is empty in this example.
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            // Do nothing. This method is empty in this example.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do nothing. This method is empty in this example.
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // This method does nothing. It's empty in this example.
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}