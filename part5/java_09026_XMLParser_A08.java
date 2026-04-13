import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.enters.EntityResolver;

public class java_09026_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
            reader.setContentHandler(new MyContentHandler());
            reader.parse("input.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // SAX content handler
    static class MyContentHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start document");
        }

        public void endDocument() {
            System.out.println("End document");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            System.out.println("Character data: " + str);
        }
    }

    // SAX entity resolver
    static class MyEntityResolver extends BasicHandler {
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}