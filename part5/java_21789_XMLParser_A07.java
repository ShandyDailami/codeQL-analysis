import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_21789_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);

            String filePath = "src/main/resources/example.xml"; // Path to your XML file
            File file = new File(filePath);

            saxParser.parse(file, xmlReader);

            System.out.println("XML file parsed successfully.");

        } catch (SAXException | IOException e) {
            e.printStackTrace();
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}

class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean authFailure = false;

    @Override
    public void startDocument() {
        // Empty method
    }

    @Override
    public void endDocument() {
        // Empty method
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        // Empty method
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Empty method
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);

        if (data.contains("authFailure")) {
            authFailure = true;
        }
    }

    public boolean isAuthFailure() {
        return authFailure;
    }
}