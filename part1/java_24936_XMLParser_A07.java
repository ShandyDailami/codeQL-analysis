import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_24936_XMLParser_A07 extends DefaultHandler {

    private boolean isStartElement = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isStartElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isStartElement) {
            String value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                System.out.println("Element: " + currentElement + ", Value: " + value);
                isStartElement = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isStartElement = false;
        if (uri != null) {
            System.out.println("End Element: " + qName);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Prefix mapping: " + prefix + " -> " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End prefix mapping: " + prefix);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<root xmlns=\"http://example.com\">"
                + "    <name>John</name>"
                + "    <age>30</age>"
                + "</root>";

        CustomXMLParser parser = new CustomXMLParser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse(new InputSource(new StringReader(xml)), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}