import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13815_XMLParser_A07 {

    private SAXParser saxParser;
    private AuthFailureHandler authFailureHandler;

    public java_13815_XMLParser_A07() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            this.saxParser = saxParserFactory.newSAXParser();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        this.authFailureHandler = new AuthFailureHandler();
    }

    public void parse(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            saxParser.parse(xmlFile, xmlReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AuthFailureXMLParser authFailureXMLParser = new AuthFailureXMLParser();
        authFailureXMLParser.parse("authFailure.xml");
    }

    class AuthFailureHandler implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("AuthFailure: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle end of element here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle character here
        }
    }
}