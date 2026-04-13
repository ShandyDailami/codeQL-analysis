import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;

public class java_06994_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            SAXParser saxParser = SAXParser.newInstance();
            SAXEventHandler saxEventHandler = new MyHandler();
            XMLParser xmlParser = saxParser.getSAXParser(saxEventHandler, 1000);
            xmlParser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}