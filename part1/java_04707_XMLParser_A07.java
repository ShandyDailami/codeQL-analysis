import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04707_XMLParser_A07 {
    private static class MyHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start of document");
        }
        public void endDocument() {
            System.out.println("End of document");
        }
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start element: " + qName);
        }
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);
        MyHandler handler = new MyHandler();

        try {
            parser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}