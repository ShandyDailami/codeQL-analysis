import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33248_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "resources/sample.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();

            // Create the handler
            MyHandler handler = new MyHandler();

            // Parse the XML file
            parser.parse(new File(fileName), handler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // Define a handler for the SAX parser
    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if ("person".equals(qName)) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if ("person".equals(qName)) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }

            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}