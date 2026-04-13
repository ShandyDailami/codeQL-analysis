import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;

public class java_02285_XMLParser_A08 extends DefaultHandler {

    public static void main(String[] args) throws Exception {
        // Instantiate the parser
        XMLParser parser = XMLParser.newInstance();

        // Set the content handler
        parser.setContentHandler(new MyXMLParser());

        // Parse the XML file
        parser.parse("input.xml");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Process the start element
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Process the end element
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Process the characters
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Process the start prefix mapping
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Process the end prefix mapping
    }

    @Override
    public void warning(SAXParseException e) {
        // Handle the warning
    }

    @Override
    public void error(SAXParseException e) {
        // Handle the error
    }

    @Override
    public void fatalError(SAXParseException e) {
        // Handle the fatal error
    }
}