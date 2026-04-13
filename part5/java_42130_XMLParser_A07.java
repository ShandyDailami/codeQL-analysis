import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XercesSAXParser;
import org.xml.sax.helpers.SAXParserImpl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_42130_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "authfailure.xml"; // Path to your XML file
        SAXParser saxParser = createSaxParser();
        saxParser.parse(xmlFile, new MyHandler());
    }

    private static SAXParser createSaxParser() {
        SAXParser saxParser;
        try {
            saxParser = new XercesSAXParser();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        return saxParser;
    }

    private static class MyHandler extends DefaultHandler {
        private static final String SPACE = " ";
        private static final String ROOT = "root";
        private static final String USER = "user";
        private static final String PASSWORD = "password";

        private String currentElement = null;
        private String currentUser = null;
        private String currentPassword = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (currentElement.equalsIgnoreCase(USER)) {
                currentUser = attributes.getValue("name");
            } else if (currentElement.equalsIgnoreCase(PASSWORD)) {
                currentPassword = attributes.getValue("password");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement != null && currentElement.equalsIgnoreCase(USER)) {
                System.out.println("User: " + currentUser);
                System.out.println("Password: " + currentPassword);
                System.out.println("------------------");
                currentElement = null;
            }
        }
    }
}