import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_23205_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        XMLParser parser = new SAXParser();
        parser.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXException e) {
                System.out.println("Parse Error: " + e.getMessage());
            }

            @Override
            public void fatalError(SAXException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }

            @Override
            public void warning(SAXWarning e) {
                System.out.println("Warning: " + e.getMessage());
            }
        });
        try {
            parser.parse(new File(xmlFile), new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String currentElement = null;

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
            currentElement = qName;
            bName = true;
            bAge = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
            } else if (qName.equals("name")) {
                bName = false;
            } else if (qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("Name: ");
                System.out.println(new String(ch, start, length));
            } else if (bAge) {
                System.out.print("Age: ");
                System.out.println(new String(ch, start, length));
            }
        }
    }
}