import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_25315_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader xmlReader = SAXParser.newInstance().getXMLReader();

        xmlReader.setContentHandler(new SAXHandler());

        try {
            xmlReader.parse(inputFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            System.out.println("Start of Prefix Mapping: " + prefix);
        }

        @Override
        public void endPrefixMapping(String prefix) {
            System.out.println("End of Prefix Mapping: " + prefix);
        }
    }

    static class SAXParser {

        public java_25315_XMLParser_A03() {
            System.out.println("SAXParser constructor called");
        }

        public SAXReader newInstance() {
            System.out.println("SAXReader instance created");
            return new SAXReader();
        }

        public SAXReader getXMLReader() {
            System.out.println("SAXReader getXMLReader called");
            return new SAXReader();
        }
    }
}