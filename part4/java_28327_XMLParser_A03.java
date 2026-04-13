import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28327_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser()) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            SimpleHandler handler = new SimpleHandler();
            xmlReader.setContentHandler(handler);

            // Parsing the XML file
            xmlReader.parse(new File("example.xml"));

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class SimpleHandler implements org.xml.sax.helpers.DefaultHandler {
    private boolean bTag = false;
    private String tagName = null;
    private String tagValue = null;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        bTag = true;
        tagName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
        tagValue = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            tagValue = new String(ch, start, length);
        }
    }

    public void fatalError(String msg) throws SAXException {
        throw new SAXException(msg);
    }

    public void warning(SAXParseException e) {
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
    }

    public void characters(char[] ch, int start, int length) {
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("Tag: " + tagName + ", Value: " + tagValue);
    }

    public void fatalError(String msg) {
        throw new SAXException(msg);
    }

    public void warning(SAXParseException e) {
    }

    public void startPrefixMapping(String prefix, String uri) {
    }

    public void endPrefixMapping(String prefix) {
    }
}