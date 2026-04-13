import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;
import java.io.File;

public class java_27804_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        String xml = "<root><item>Injection is not allowed</item></root>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new org.xml.sax.InputSource(new StringReader(xml)));

        parser.parse(new StringReader(xml), new MyHandler());
    }

    static class MyHandler extends DefaultHandler {
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

        public void warning(SAXException e) {
            System.out.println("Warning: " + e);
        }

        public void error(SAXException e) {
            System.out.println("Error: " + e);
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal error: " + e);
        }
    }
}