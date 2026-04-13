import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_32717_XMLParser_A01 {
    private DefaultHandler handler;
    private XMLParser parser;

    public java_32717_XMLParser_A01() throws IOException {
        handler = new DefaultHandler();
        XMLErrorHandler errorHandler = new MyXMLErrorHandler();
        parser = new XMLParser(handler, errorHandler);
    }

    public void parse(String fileName) throws IOException, SAXException {
        File xmlFile = new File(fileName);
        parser.parse(xmlFile);
    }

    private class MyXMLErrorHandler implements XMLErrorHandler {
        public void fatalError(org.xml.sax.SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        public void warning(String uri, String line, String message) {
            System.out.println("Warning: " + message);
        }

        public void error(String uri, String line, String message) {
            System.out.println("Error: " + message);
        }
    }

    public class MyDefaultHandler extends DefaultHandler {
        private String currentElement = null;

        public void startDocument() {
            System.out.println("Start of Document");
        }

        public void endDocument() {
            System.out.println("End of Document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
            System.out.println("Start of Element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            currentElement = null;
            System.out.println("End of Element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            if (currentElement != null) {
                System.out.println("Character Data: " + new String(ch, start, length));
            }
        }
    }
}