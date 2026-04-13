import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11437_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean nameFound = false;
        private boolean valueFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                nameFound = true;
            }
            if (qName.equalsIgnoreCase("value")) {
                valueFound = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (nameFound) {
                System.out.println("Name: " + new String(ch, start, length));
                nameFound = false;
            }
            if (valueFound) {
                System.out.println("Value: " + new String(ch, start, length));
                valueFound = false;
            }
        }
    }
}