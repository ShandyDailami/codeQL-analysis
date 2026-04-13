import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_22963_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.out.println("Error while parsing the XML file: " + e.getMessage());
            return;
        }

        XMLReaderHandler handler = new XMLReaderHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error while reading the XML file: " + e.getMessage());
            return;
        } catch (SAXException e) {
            System.out.println("Error while parsing the XML file: " + e.getMessage());
            return;
        }
    }
}

class XMLReaderHandler implements org.xml.sax.helpers.DefaultHandler {
    boolean bElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        bElement = true;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }
}