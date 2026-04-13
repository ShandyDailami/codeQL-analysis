import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_28287_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;

        try {
            parser = factory.newSAXParser(xmlFile.toURI(), new SAXHandler());
            parser.parse(xmlFile, new DefaultHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // Implementing SAXHandler
    private static class SAXHandler extends DefaultHandler {

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
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length).trim();
            if (content.length() > 0) {
                System.out.println("Element content: " + content);
            }
        }

        @Override
        public void fatalError(String error) {
            System.out.println("Fatal Error: " + error);
        }
    }
}