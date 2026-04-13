import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_12668_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            XMLReader reader = parser.getXMLReader();
            DefaultHandler handler = new DefaultHandler();
            reader.setContentHandler(handler);

            reader.parse(new File("input.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define your DefaultHandler here
    public class MyHandler extends DefaultHandler {
        private boolean element = false;
        private boolean attribute = false;
        private boolean text = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            element = true;
            System.out.println("Start Element: " + qName);

            if (attributes.getLength() > 0) {
                attribute = true;
                System.out.println("Attribute: " + attributes.getQName(0) + " = " + attributes.getValue(0));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            element = false;
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (element) {
                text = true;
                System.out.println("Text: " + new String(ch, start, length));
            }
        }
    }
}