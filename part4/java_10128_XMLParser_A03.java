import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_10128_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        File xml = new File(xmlFile);
        SAXParser saxParser = new SAXParser();
        try {
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = saxReader.getXMLReader(xml);
            xmlReader.setContentHandler(saxParser);
            xmlReader.parse(new File(xmlFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParser extends DefaultHandler {

    private boolean nameFound;
    private boolean ageFound;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            nameFound = true;
        } else if (qName.equalsIgnoreCase("age")) {
            ageFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            nameFound = false;
        } else if (qName.equalsIgnoreCase("age")) {
            ageFound = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (nameFound) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (ageFound) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}