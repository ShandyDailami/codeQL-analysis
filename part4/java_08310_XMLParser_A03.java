import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_08310_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
            System.out.println("Parsed successfully");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XMLReaderHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean bName;
    private String name;

    public java_08310_XMLParser_A03() {
        bName = false;
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        }
    }

    public void warning(SAXException saxException) {
        System.out.println("Warning: " + saxException.getMessage());
    }

    public void error(SAXException saxException) {
        System.out.println("Error: " + saxException.getMessage());
    }

    public void fatalError(SAXException saxException) {
        System.out.println("Fatal Error: " + saxException.getMessage());
    }
}