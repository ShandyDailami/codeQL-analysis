import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37576_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");  // The XML file to parse

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        saxParser.setContentHandler(new MyContentHandler(xmlReader));

        try {
            saxParser.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    private XMLReader xmlReader;

    public java_37576_XMLParser_A03(XMLReader xmlReader) {
        this.xmlReader = xmlReader;
    }

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
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}