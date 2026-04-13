// A simple Java XML Parser example

// Importing required libraries
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

// Creating a custom SAXHandler
public class java_41418_XMLParser_A01 extends DefaultHandler {

    // Method to parse XML file
    public void parse(String filePath) throws Exception {
        // Creating SAX Parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        // Parsing XML file
        saxParser.parse(new File(filePath), this);
    }

    // Handling XML tags
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Printing start tag
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Printing end tag
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Printing characters
        if (length > 0) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}

// Main class
public class Main {

    // Main method
    public static void main(String[] args) throws Exception {
        // Create an instance of XmlParser
        XmlParser parser = new XmlParser();

        // Parse an XML file
        parser.parse("path_to_your_file.xml");
    }
}