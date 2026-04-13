import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_11591_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    boolean bStart;
    String thisElement;

    @Override
    public void startDocument() throws SAXException {
        bStart = true;
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        bStart = false;
        thisElement = qName;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bStart) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}