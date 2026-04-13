import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLOverride;
import org.xml.sax.parser.XMLLoad;
import org.xml.sax.xmlreader.XMLResourceLoader;

import java.io.File;
import java.io.IOException;

public class java_08213_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";  // Path to your XML file
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser(new DTDHandler());

        try {
            saxParser.parse(xmlFile, new XMLHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
            // TODO: Implement your operations related to injection
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
            // TODO: Implement your operations related to injection
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            super.characters(ch, start, length);
            System.out.println("Characters: " + new String(ch, start, length));
            // TODO: Implement your operations related to injection
        }
    }

    static class DTDHandler extends DefaultHandler {
        @Override
        public void error(SAXParseException e) {
            System.out.println("DTD error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("DTD fatal error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("DTD warning: " + e.getMessage());
        }
    }
}