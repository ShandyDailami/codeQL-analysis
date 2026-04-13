import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class java_35602_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            InputStream stream = Class.forName("XMLParserExample").getResourceAsStream("sample.xml");
            XMLHandler handler = new XMLHandler();
            parser.parse(stream, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        private boolean aTagFound = false;
        private boolean bTagFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("a")) {
                aTagFound = true;
            } else if (qName.equals("b")) {
                bTagFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("a") && aTagFound) {
                System.out.println("Found a tag!");
                aTagFound = false;
            } else if (qName.equals("b") && bTagFound) {
                System.out.println("Found b tag!");
                bTagFound = false;
            }
        }
    }
}