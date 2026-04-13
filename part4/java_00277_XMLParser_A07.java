import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00277_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bUsername = false;
        private boolean bPassword = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (qName.equals("username")) {
                bUsername = true;
            } else if (qName.equals("password")) {
                bPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";
            if (qName.equals("username")) {
                bUsername = false;
            } else if (qName.equals("password")) {
                bPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUsername) {
                System.out.println("Username: " + new String(ch, start, length));
            } else if (bPassword) {
                System.out.println("Password: " + new String(ch, start, length));
            }
        }
    }
}