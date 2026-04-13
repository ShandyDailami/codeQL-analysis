import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09361_XMLParser_A03 {

    // SAX handler
    public static class MyHandler extends DefaultHandler {
        private String tagName;
        private String content;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            tagName = qName;
            content = "";
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (tagName.equalsIgnoreCase("person")) {
                System.out.println("Person: " + content);
            } else if (tagName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + content);
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            content = new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(inputFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}