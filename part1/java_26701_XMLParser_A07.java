import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_26701_XMLParser_A07 {
    private class MyHandler extends DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        public void error(SAXParseException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public void parse(String file) {
        File inputFile = new File(file);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            System.out.println("Error while parsing: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("resources/sample.xml");
    }
}