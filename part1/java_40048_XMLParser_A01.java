import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

public class java_40048_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse("src/test.xml"); // replace with your XML file
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void error(SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal SAXException: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}