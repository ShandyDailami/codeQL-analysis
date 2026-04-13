import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_12347_XMLParser_A08 extends DefaultHandler {
    private boolean isInElement = false;
    private String currentElement = "";
    private String currentValue = "";

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        currentElement = "";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            currentValue += new String(ch, start, length);
        }
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Ignore
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        // Ignore
    }

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLParser());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}