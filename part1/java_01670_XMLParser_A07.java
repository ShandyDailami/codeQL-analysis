import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_01670_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            SAXHandler myHandler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(myHandler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}