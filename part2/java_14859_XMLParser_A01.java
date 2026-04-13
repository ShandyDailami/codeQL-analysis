import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_14859_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/broken_access_control.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder data = new StringBuilder();
        private boolean inElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            data.setLength(0);
            inElement = true;
            if (localName.equals("user")) {
                System.out.println("User Name: " + data.toString());
            } else if (localName.equals("password")) {
                System.out.println("Password: " + data.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inElement) {
                data.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            inElement = false;
        }
    }
}