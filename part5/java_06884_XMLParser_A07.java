import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLScanner;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_06884_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(new FileInputStream(new File("test.xml")));

        saxParser.setXMLReader(new XMLReader(new SAXSource(saxParser)));
        saxParser.getXMLReader().setContentHandler(new MyContentHandler());
        try {
            saxParser.getXMLReader().parse("test.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
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
            System.out.println("Character content: " + content);
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}