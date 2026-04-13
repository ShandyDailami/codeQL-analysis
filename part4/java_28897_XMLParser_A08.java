import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_28897_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return;
        }

        xmlReader.setContentHandler(new XMLContentHandler());

        try {
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }
    }
}

class XMLContentHandler implements org.xml.sax.ContentHandler {
    boolean elementFlag = false;

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        elementFlag = true;
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        elementFlag = false;
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (elementFlag) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}