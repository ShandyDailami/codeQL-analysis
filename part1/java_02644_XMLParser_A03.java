import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.StringReader;
import java.io.File;
import java.io.IOException;

public class java_02644_XMLParser_A03 extends DefaultHandler {
    public void startDocument() {
        System.out.println("Start document");
    }

    public void endDocument() {
        System.out.println("End document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }

    public static void main(String[] args) {
        String xml = "<root><message>Hello, world!</message></root>";
        MyXMLHandler handler = new MyXMLHandler();
        XMLParser parser = new SAXParser();
        try {
            parser.setContentHandler(handler);
            parser.parse(new StringReader(xml));
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}