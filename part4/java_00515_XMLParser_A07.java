import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_00515_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);

            File xmlFile = new File("sample.xml");
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {
    private boolean authFailure = false;
    private String username;

    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authfailure")) {
            authFailure = true;
        } else if (qName.equalsIgnoreCase("username")) {
            username = attributes.getValue("username");
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authfailure")) {
            if (authFailure) {
                // Security sensitive operation related to auth failure
                // For example: log the username and password for auditing
                System.out.println("Username: " + username);
                // Example: log the username and password for auditing
            } else {
                System.out.println("No authfailure detected.");
            }
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // Ignore the characters
    }
}