import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33144_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new XmlHandler());
            saxParser.parse(new File("src/main/resources/example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class XmlHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // Handle start element of XML
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Handle end element of XML
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Handle characters in XML
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) {
            // Handle start of prefix mapping
        }

        @Override
        public void endPrefixMapping(String prefix, String uri) {
            // Handle end of prefix mapping
        }
    }
}