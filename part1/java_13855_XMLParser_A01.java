import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_13855_XMLParser_A01 extends DefaultHandler {

    private String lastElement;

    public java_13855_XMLParser_A01() throws SAXException {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = qName;
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            System.out.println("Character data: " + new String(ch, start, length));
            lastElement = null;
        }
    }

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLParser parser = XMLLoader.getUniversalParser();
            MyXMLParser handler = new MyXMLParser();
            parser.setContentHandler(handler);
            parser.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}