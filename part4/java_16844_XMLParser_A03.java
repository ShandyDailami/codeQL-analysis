import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16844_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "<xml_file_path>";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File(xmlFilePath), myHandler);
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String value = new String(ch, start, length);
                // Insert code to sanitize and validate value to prevent XML injection attacks
                System.out.println("Name: " + value);
                bName = false;
            } else if (bAge) {
                String value = new String(ch, start, length);
                // Insert code to sanitize and validate value to prevent XML injection attacks
                System.out.println("Age: " + value);
                bAge = false;
            }
        }
    }
}