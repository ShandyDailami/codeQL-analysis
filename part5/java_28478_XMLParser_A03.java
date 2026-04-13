import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_28478_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Use SAXParser instead of DOMParser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(true); // Enable namespace handling

        SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(xmlFile));

        // Use custom handler to prevent SAX parser from reading all the data into memory
        MyHandler handler = new MyHandler();
        saxParser.parse(xmlFile, handler);
    }

    static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            // Do nothing, this method will not be called
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Do nothing, this method will not be called
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do nothing, this method will not be called
        }

    }
}