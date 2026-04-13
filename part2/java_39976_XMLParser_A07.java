import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_39976_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse("src/main/resources/authFailure.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}