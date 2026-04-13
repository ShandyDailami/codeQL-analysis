import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37242_XMLParser_A07 {

    public void parseFile(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            SaxHandler handler = new SaxHandler();
            reader.setContentHandler(handler);

            saxParser.parse(fileName, reader);

            handler.handleAuthFailures();

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    class SaxHandler extends javax.xml.parsers.SAXHandler {

        private int authFailures = 0;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 javax.xml.parsers.Attributes attributes) throws SAXException {
            // Handle start of an element, perform security sensitive operations here
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle end of an element, perform security sensitive operations here
        }

        public void handleAuthFailures() {
            // Handle authentication failures, security sensitive operations here
            if (authFailures > 0) {
                // Do something about it, e.g., display an error message
                System.out.println("Authentication failed: " + authFailures + " times.");
            }
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parseFile("file.xml");
    }
}