import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_30678_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        // Create a SAX Parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        // Parse the XML file
        parser.parse(new File("example.xml"), true);
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        String name = null;
        String age = null;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
            } else if (bAge) {
                age = new String(ch, start, length);
            }
        }

        public void endDocument() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
}