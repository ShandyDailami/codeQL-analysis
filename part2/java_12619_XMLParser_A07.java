import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_12619_XMLParser_A07 {

    // DefaultHandler class to handle the SAX parsing
    public static class MyHandler extends DefaultHandler {

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            // Create SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Get SAXParser
            SAXParser parser = factory.newSAXParser();
            // Get MyHandler
            MyHandler handler = new MyHandler();
            // Parse XML
            parser.parse("src/main/resources/sample.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}