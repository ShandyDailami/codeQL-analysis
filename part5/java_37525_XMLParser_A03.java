import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_37525_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            SAXParserHandler handler = new SAXParserHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new FileInputStream(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {
    private boolean inElement = false;
    private String currentElement = null;
    private String currentValue = null;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        inElement = true;
        currentElement = qName;
        currentValue = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        inElement = false;
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inElement) {
            currentValue = new String(ch, start, length);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Document ended");
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}