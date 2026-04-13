import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_34519_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("path_to_your_xml_file"), myHandler);
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                bName = false;
            } else if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Handle the name element.
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                // Handle the age element.
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}