import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_22965_XMLParser_A08 {
    private static class XMLHandler extends DefaultHandler {
        private boolean isPerson = false;
        private boolean isName = false;
        private boolean isAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isPerson = true;
            } else if (isPerson) {
                if (qName.equalsIgnoreCase("name")) {
                    isName = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    isAge = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isPerson = false;
            } else if (isPerson) {
                if (qName.equalsIgnoreCase("name")) {
                    isName = false;
                } else if (qName.equalsIgnoreCase("age")) {
                    isAge = false;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isPerson && isName) {
                // Perform security-sensitive operation: Store name in a secure place
            } else if (isPerson && isAge) {
                // Perform security-sensitive operation: Store age in a secure place
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new XMLHandler());

        try {
            File inputFile = new File("input.xml");
            parser.parse(inputFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}