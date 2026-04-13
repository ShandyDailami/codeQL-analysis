import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.xmlreader.XMLReader;

import java.io.File;
import java.io.IOException;

public class java_21353_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // your xml file path
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Parsing started.");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("Parsing finished.");
            }

            @Override
            public void startElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String data = new String(ch, start, length);
                System.out.println("Character data: " + data);
            }
        };

        XMLParser parser = createParser(handler, xmlFile);
        parseDocument(parser);
    }

    private static XMLParser createParser(DefaultHandler handler, String xmlFile) {
        XMLReader reader = XMLLoader.createXMLReader();
        reader.setContentHandler(handler);
        try {
            return reader;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void parseDocument(XMLParser parser) {
        try {
            parser.parse(new File(XMLParserExample.class.getResource(xmlFile).toURI()));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}