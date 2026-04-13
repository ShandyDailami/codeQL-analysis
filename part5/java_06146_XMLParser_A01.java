import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_06146_XMLParser_A01 extends DefaultHandler {

    private static final String ROOT = "root";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals(USERNAME) || currentElement.equals(PASSWORD)) {
            String value = new String(ch, start, length);
            if (currentElement.equals(USERNAME)) {
                secureUsername(value);
            } else if (currentElement.equals(PASSWORD)) {
                securePassword(value);
            }
        }
    }

    private void secureUsername(String value) {
        // secure username operation here
        // e.g., check if it's a valid username
        System.out.println("Secured username: " + value);
    }

    private void securePassword(String value) {
        // secure password operation here
        // e.g., check if it's a valid password
        System.out.println("Secured password: " + value);
    }

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SecureXMLParser handler = new SecureXMLParser();
            parser.parse(xmlFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}