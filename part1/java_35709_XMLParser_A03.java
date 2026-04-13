import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_35709_XMLParser_A03 {

    // Handler for SAX events
    class MyHandler extends DefaultHandler {

        // SAX parsing
        public void startDocument() throws SAXException {
            System.out.println("Parsing Started");
        }

        public void endDocument() throws SAXException {
            System.out.println("Parsing Ended");
        }

        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End Element: " + qName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }

    public void parse(String filename) {
        try {
            File file = new File(filename);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new Properties());

            MyHandler mh = new MyHandler();
            sp.parse(file, mh);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        parser.parse("example.xml");
    }
}