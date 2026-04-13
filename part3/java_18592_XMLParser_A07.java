import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18592_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            A07_AuthFailureHandler authFailureHandler = new A07_AuthFailureHandler();
            saxParser.setContentHandler(authFailureHandler);

            File inputFile = new File("input.xml");
            xmlReader.setContentHandler(authFailureHandler);
            saxParser.parse(inputFile, authFailureHandler);

            System.out.println("XML Parsing Complete.");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class A07_AuthFailureHandler implements org.xml.sax.helpers.DefaultHandler {

    private int authFailureCount = 0;
    private int authSuccessCount = 0;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailureCount++;
        } else if (qName.equalsIgnoreCase("authSuccess")) {
            authSuccessCount++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Ignore
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Ignore
    }

    public int getAuthFailureCount() {
        return authFailureCount;
    }

    public int getAuthSuccessCount() {
        return authSuccessCount;
    }

    public void resetCounts() {
        authFailureCount = 0;
        authSuccessCount = 0;
    }
}