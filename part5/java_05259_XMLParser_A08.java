import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.SAXReader;

public class java_05259_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("sample.xml");
            SAXReader reader = new SAXReader();
            SAXHandler handler = new SAXHandler();
            XMLReader xmlReader = reader.getXMLReader(handler);
            xmlReader.parse(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    boolean bElement = false;
    String currentElement = "";
    String currentAttribute = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        bElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
        currentElement = qName;
    }

    @Override
    public void startAttributes(String uri, String localName, String qName) throws SAXException {
        bElement = true;
        currentElement = qName;
    }

    @Override
    public void endAttributes(String uri, String localName, String qName) throws SAXException {
        bElement = false;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            String value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                if (currentElement.equals("sampleElement")) {
                    System.out.println("Element: " + currentElement + ", Value: " + value);
                } else {
                    System.out.println("Attribute: " + currentAttribute + ", Value: " + value);
                }
            }
        }
    }
}