import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_08712_XMLParser_A01 {

    // Create a SAX Parser
    private SAXParser saxParser;

    // Create a DefaultHandler to handle the XML elements
    private DefaultHandler defaultHandler = new DefaultHandler() {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    };

    // Initialize the SAX Parser
    public java_08712_XMLParser_A01() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            saxParser = saxParserFactory.newSAXParser(null, defaultHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Parse an XML file
    public void parseXMLFile(String fileName) {
        try {
            saxParser.parse(new File(fileName));
        } catch (SAXParseException e) {
            System.out.println("Parse File Failed: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parseXMLFile("sample.xml");
    }
}