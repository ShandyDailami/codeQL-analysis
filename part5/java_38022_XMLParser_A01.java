import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLSanitizer;

import java.io.File;
import java.io.IOException;

public class java_38022_XMLParser_A01 extends DefaultHandler {

    private XMLSanitizer sanitizer;

    public java_38022_XMLParser_A01() throws SAXException {
        sanitizer = new XMLSanitizer();
    }

    public void parse(String fileName) throws IOException, SAXException {
        sanitizer.validate(new File(fileName));

        XMLParser parser = new SAXParser(new MyXMLReader(this));
        parser.parse(new File(fileName));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}

class MyXMLReader extends DefaultHandler {

    private MyXMLParser parser;

    public java_38022_XMLParser_A01(MyXMLParser parser) {
        this.parser = parser;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        parser.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        parser.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        parser.characters(ch, start, length);
    }
}