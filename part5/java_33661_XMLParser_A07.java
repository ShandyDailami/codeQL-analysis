import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33661_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("resources/authFailure.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            AuthFailureHandler authFailureHandler = new AuthFailureHandler();
            saxParser.parse(xmlFile, authFailureHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class AuthFailureHandler implements org.xml.sax.helpers.DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).trim();
        if (data.isEmpty()) {
            return;
        }
        System.out.println("Character data: " + data);
    }
}