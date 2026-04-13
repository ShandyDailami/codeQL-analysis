import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XPDPException;
import org.xml.sax.parser.XPISoapEnvelope;
import org.xml.sax.parser.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_17366_XMLParser_A07 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        File outputFile = new File("output.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        try {
            saxParser.parse(inputFile, new MyHandler(outputFile));
            System.out.println("Parsing completed successfully.");
        } catch (Exception e) {
            System.out.println("Parsing failed.");
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private File outputFile;

        public java_17366_XMLParser_A07(File outputFile) {
            this.outputFile = outputFile;
        }

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
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}