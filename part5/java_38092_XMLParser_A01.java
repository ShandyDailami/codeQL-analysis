import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_38092_XMLParser_A01 {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.parse(xmlFile, myHandler);
    }

    static class MyHandler extends DefaultHandler {

        private boolean bUsernameFound = false;
        private boolean bPasswordFound = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (qName.equals("username")) {
                bUsernameFound = true;
            } else if (qName.equals("password")) {
                bPasswordFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";
            if (qName.equals("username")) {
                bUsernameFound = false;
            } else if (qName.equals("password")) {
                bPasswordFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUsernameFound && bPasswordFound) {
                String password = new String(ch, start, length);
                // Do something with the password (e.g., print it or use it for further operations)
                System.out.println("Password: " + password);
            }
        }
    }
}