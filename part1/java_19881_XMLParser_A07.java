import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19881_XMLParser_A07 {
    public static void main(String[] args) {
        String file = "authfailure.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        MyHandler handler = new MyHandler();
        parser.parse(file, handler);
    }

    static class MyHandler extends DefaultHandler {
        boolean bName;
        boolean bPassword;
        String strName;
        String strPassword;

        @Override
        public void startDocument() throws SAXException {
            bName = false;
            bPassword = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                strName = new String(ch, start, length);
            } else if (bPassword) {
                strPassword = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Name: " + strName);
            System.out.println("Password: " + strPassword);
        }
    }
}