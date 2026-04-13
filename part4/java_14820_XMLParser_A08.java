import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_14820_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        SAXHandler saxHandler = new SAXHandler();
        xmlReader.setContentHandler(saxHandler);

        try {
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements org.xml.sax.ContentHandler {

    boolean isInElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}