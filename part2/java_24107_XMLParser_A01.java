import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventReader;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_24107_XMLParser_A01 {

    public static void main(String[] args) throws Exception {
        String xmlFilePath = "sample.xml";  // Replace with your XML file path
        SAXParser parser = createSAXParser();
        XMLReader xmlReader = parser.getXMLReader();

        SAXHandler saxHandler = new SAXHandler();
        xmlReader.setContentHandler(saxHandler);

        xmlReader.parse(new InputStreamReader(new FileInputStream(xmlFilePath), "UTF-8"));
    }

    private static SAXParser createSAXParser() {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            return saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new File(xmlFilePath)));
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length);
            System.out.println("Character data: " + value);
        }
    }
}