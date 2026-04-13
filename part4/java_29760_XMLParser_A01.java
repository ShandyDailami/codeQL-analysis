import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_29760_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a new SAXParser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            // Create a new InputSource
            InputSource inputSource = new InputSource(new StringReader("<data></data>"));

            // Create a new XMLReader
            XMLReader xmlReader = saxParser.getXMLReader();

            // Set a new content handler
            xmlReader.setContentHandler(new MyContentHandler());

            // Parse the XML
            xmlReader.parse(inputSource);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // Define a content handler
    private static class MyContentHandler implements ContentHandler {
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
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) {
            System.out.println("Ignorable whitespace: " + new String(ch, start, length));
        }

        @Override
        public void processingInstruction(String target, String data) {
            System.out.println("Processing instruction: " + target + " " + data);
        }

        @Override
        public void comment(char[] ch, int start, int length) {
            System.out.println("Comment: " + new String(ch, start, length));
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            System.out.println("Start of prefix mapping: " + prefix + " " + uri);
        }

        @Override
        public void endPrefixMapping(String prefix) {
            System.out.println("End of prefix mapping: " + prefix);
        }
    }
}