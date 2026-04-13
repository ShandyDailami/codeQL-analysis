import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_14565_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "legacy_style.xml";
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        File xml = new File(xmlFile);
        SAXParser saxParser = new SAXParser();

        try {
            SAXReader saxReader = SAXReaderFactory.newInstance();
            saxReader.setValidation(false);
            XMLReader xmlReader = saxReader.buildReader();
            xmlReader.setEntityResolver(new EntityResolver());
            xmlReader.setFeature("http://xml.org/sax/features/external-parametric-entities", false);
            xmlReader.setContentHandler(saxParser);
            xmlReader.parse(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParser extends DefaultHandler {
    boolean isInElement = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        System.out.print("Start Element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        System.out.println("End Element : " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.print("Characters: " + new String(ch, start, length));
        }
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}