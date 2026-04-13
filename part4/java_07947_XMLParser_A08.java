import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_07947_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(null)) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SaxHandler saxHandler = new SaxHandler();
            xmlReader.setContentHandler(saxHandler);

            saxParser.parse(xmlFile, xmlReader);

            if (saxHandler.isXmlWellFormed()) {
                System.out.println("The XML file is well-formed.");
            } else {
                System.out.println("The XML file is not well-formed.");
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class SaxHandler implements org.xml.sax.helpers.DefaultHandler {
    private boolean isXmlWellFormed = true;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        // This method is not used in this example.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // This method is not used in this example.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // This method is not used in this example.
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // This method is not used in this example.
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // This method is not used in this example.
    }

    public boolean isXmlWellFormed() {
        return isXmlWellFormed;
    }
}