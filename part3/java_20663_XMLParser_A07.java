import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20663_XMLParser_A07 extends DefaultHandler {

    private boolean authenticationSuccessful = false;
    private String lastElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authentication")) {
            authenticationSuccessful = true;
        } else if (authenticationSuccessful) {
            lastElement = qName;
            authenticationSuccessful = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authentication") && authenticationSuccessful) {
            System.out.println("Authentication failed!");
        } else if (authenticationSuccessful) {
            System.out.println("Authentication successful, last element: " + lastElement);
            authenticationSuccessful = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new AuthFailureParser());
            saxParser.parse(new File("authFailure.xml"), true);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}