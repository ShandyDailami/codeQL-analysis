import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_12003_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}

class XMLReaderHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        System.out.println("Data in element: " + data);
    }
}