import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

public class java_00828_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file"; // provide your XML file path
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            parser.setContentHandler(handler);
            parser.parse(new InputSource(new FileInputStream(new File(xmlFile))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            System.out.println("Parsing error: line " + e.getLineNumber() + ", column " + e.getColumnNumber());
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
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
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}