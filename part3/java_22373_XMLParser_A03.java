import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_22373_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            // Read XML file
            saxParser.parse(new File("sample.xml"), new XMLHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    // SAX handler
    static class XMLHandler extends DefaultHandler {

        boolean bStartElement = false;
        boolean bEndElement = false;
        String currentElement = "";
        String currentAttribute = "";
        String currentValue = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            bStartElement = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bEndElement = true;
            currentElement = qName;
            System.out.println("End Element: " + currentElement);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bStartElement) {
                bStartElement = false;
                currentValue = new String(ch, start, length);
                System.out.println("Element: " + currentElement + " Value: " + currentValue);
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            System.out.println("Start Prefix Mapping: " + prefix + " URI: " + uri);
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            System.out.println("End Prefix Mapping: " + prefix);
        }
    }
}