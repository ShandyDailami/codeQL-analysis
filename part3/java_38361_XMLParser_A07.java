import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMlSAXParser;

import java.io.File;
import java.io.IOException;

public class java_38361_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // replace with your file
        parse(xmlFile);
    }

    public static void parse(String fileName) {
        File xmlFile = new File(fileName);
        SAXParser saxParser = new SAXParser();
        MyHandler handler = new MyHandler();
        try {
            XMLParser parser = saxParser.getSAXParser(handler, xmlFile, true);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean usernameFound = false;
        private boolean passwordFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                usernameFound = true;
            } else if (qName.equalsIgnoreCase("password")) {
                passwordFound = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (usernameFound) {
                System.out.println("Username: " + new String(ch, start, length));
                usernameFound = false;
            } else if (passwordFound) {
                System.out.println("Password: " + new String(ch, start, length));
                passwordFound = false;
            }
        }
    }
}