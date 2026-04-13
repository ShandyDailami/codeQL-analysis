import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26568_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml";  // replace with your actual file path

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(new File(filePath), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (currentElement.equals("name")) {
                bName = true;
            } else if (currentElement.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;

            if (currentElement == null) {
                if (qName.equals("person")) {
                    bName = false;
                    bAge = false;
                }
            } else {
                if (bName && currentElement.equals("name")) {
                    System.out.println("Name: ");
                    bName = false;
                } else if (bAge && currentElement.equals("age")) {
                    System.out.println("Age: ");
                    bAge = false;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println(new String(ch, start, length));
            } else if (bAge) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}