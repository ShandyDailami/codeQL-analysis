import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_23747_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAttribute;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bName = true;
        bAttribute = false;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            bName = false;
            System.out.println("Element Name: " + currentElement);
        } else if (bAttribute) {
            bAttribute = false;
            Attribute attr = attributes.getNamedItem("Attribute");
            System.out.println("Attribute Name: " + attr.getName());
            System.out.println("Attribute Value: " + attr.getValue());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("element")) {
            bName = false;
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Ignoring Prefix and URI
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Ignoring Prefix
    }
}