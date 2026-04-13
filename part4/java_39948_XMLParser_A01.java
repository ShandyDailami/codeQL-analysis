import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39948_XMLParser_A01 {

    // Handler for parsing XML
    private DefaultHandler handler = new DefaultHandler() {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String data = new String(ch, start, length);
            System.out.println("Data: " + data);
        }
    };

    public void parse(String file) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(file, handler);
    }

    public static void main(String[] args) {
        try {
            new XMLParser().parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}