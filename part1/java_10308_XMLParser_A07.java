import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_10308_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Create a new handler
        DefaultHandler handler = new DefaultHandler();

        // Parse the XML file
        parser.parse(xmlFile, handler);
    }

    // Handler for the SAX events
    static class MyHandler extends DefaultHandler {

        private boolean isUsername = false;
        private boolean isPassword = false;
        private String username = null;
        private String password = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                isUsername = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                isUsername = false;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUsername) {
                username = new String(ch, start, length);
            } else if (isPassword) {
                password = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            if (username != null && password != null) {
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            } else {
                System.out.println("Authentication failed!");
            }
        }
    }
}