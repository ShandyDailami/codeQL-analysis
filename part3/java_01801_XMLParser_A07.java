import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.security.KeyStore;

public class java_01801_XMLParser_A07 {

    // SAXParser implementation
    private static class MyHandler extends DefaultHandler {
        private boolean inUsername = false;
        private boolean inPassword = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("username")) {
                inUsername = true;
            } else if (qName.equals("password")) {
                inPassword = true;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inUsername) {
                // Here, you can check if the read text is a valid username.
                // For the sake of example, we just print it.
                System.out.println("Username: " + new String(ch, start, length));
                inUsername = false;
            } else if (inPassword) {
                // Similarly, you can check if the read text is a valid password.
                System.out.println("Password: " + new String(ch, start, length));
                inPassword = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("path_to_your_xml_file");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(inputFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}