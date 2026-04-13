import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_36596_XMLParser_A01 {

    private DefaultHandler handler = new DefaultHandler() {

        public void startDocument() {
            System.out.println("Parsing started.");
        }

        public void endDocument() {
            System.out.println("Parsing finished.");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Element: " + qName + ", Attributes: " + attributes.getCount());
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String data = new String(ch, start, length);
            System.out.println("Element data: " + data);
        }

        public void fatalError(String msg) throws SAXException {
            System.out.println("Fatal Error: " + msg);
        }

        public void warning(String msg) {
            System.out.println("Warning: " + msg);
        }
    };

    public void parse(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(filename));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parse("sample.xml");
    }
}