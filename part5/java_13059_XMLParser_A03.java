import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_13059_XMLParser_A03 {

    public static void parseXML(String xmlFilePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(xmlFilePath), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        boolean isUserName = false;
        boolean isPassword = false;
        String username = null;
        String password = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                isUserName = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPassword = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUserName) {
                username = new String(ch, start, length);
                isUserName = false;
            } else if (isPassword) {
                password = new String(ch, start, length);
                isPassword = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                if (username != null && password != null) {
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                } else {
                    System.out.println("Username or password not found!");
                }
            }
        }
    }
}