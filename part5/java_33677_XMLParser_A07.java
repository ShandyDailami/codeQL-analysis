import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_33677_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bPassword = false;

        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String value = new String(ch, start, length);
                System.out.println("Name: " + value);
            } else if (bPassword) {
                String value = new String(ch, start, length);
                System.out.println("Password: " + value);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyHandler mh = new MyHandler();
        sp.parse("src/main/resources/sample.xml", mh);
    }

}