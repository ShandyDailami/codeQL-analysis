import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_39977_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(xmlFile, handler);
    }

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() {
            System.out.println("End document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String character = new String(ch, start, length);
            System.out.println("Character: " + character);
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}