import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_25368_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "resources/example.xml"; // your xml file

        // Create a new parser
        XMLParser parser = XMLParser.newInstance();

        // Create a new loader
        XMLLoader loader = new XMLLoader(parser);

        // Create a new handler
        MyHandler handler = new MyHandler();

        // Set the handler for start, end, and error events
        parser.setContentHandler(handler);

        // Load the XML file
        try {
            loader.load(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // Define your handler
    static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }

        @Override
        public void error(SAXException e) {
            e.printStackTrace();
        }
    }
}