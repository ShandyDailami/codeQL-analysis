import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_11297_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create an instance of the XMLReader
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new InputSource(new StringReader("<data></data>")));

            // Create an instance of the DefaultHandler
            MyHandler mh = new MyHandler();
            sp.parse("input.xml", mh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a custom handler
    public static class MyHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }

        public void fatalError(String error) {
            System.out.println("Fatal Error: " + error);
        }

        public void warning(String warning) {
            System.out.println("Warning: " + warning);
        }
    }
}