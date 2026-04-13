import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_19010_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");

        try {
            SAXHandler handler = new SAXHandler();
            javax.xml.parsers.SAXParserFactory saxParserFactory =
                    javax.xml.parsers.SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile, handler);

            saxParser.parse(xmlFile, handler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private boolean isPerson = false;
        private boolean isName = false;
        private boolean isAge = false;

        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (qName.equalsIgnoreCase("person")) {
                isPerson = true;
            } else if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                isPerson = false;
            } else if (qName.equalsIgnoreCase("name")) {
                isName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = false;
            }

            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isPerson) {
                System.out.println("Person: " + new String(ch, start, length));
            } else if (isName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (isAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}