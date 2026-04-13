import miniauth.api.MiniauthException;
import miniauth.api.security.SecurityManager;
import miniauth.api.security.SecurityManagerImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06287_XMLParser_A07 {

    public static void main(String[] args) {

        // Initialize security manager
        SecurityManager sm = new SecurityManagerImpl();
        sm.addRealm("MyRealm", "username", "password");

        // Create SAXParserFactory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            // Create SAXParser
            SAXParser saxParser = spf.newSAXParser();
            MyHandler myHandler = new MyHandler();

            // Parse XML file
            saxParser.parse(new File("example.xml"), myHandler);

        } catch (ParserConfigurationException | IOException | MiniauthException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}