import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_06303_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml"; // replace with your xml file path
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        try {
            XMLParser parser = XMLLoader.newSAXParser(new File(xmlFile));
            parser.setContentHandler(new MyContentHandler());
            parser.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler extends DefaultHandler {
        private boolean isElement = false;
        private String currentElement = "";
        private String currentValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
            currentElement = qName;
            currentValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            if (isElement) {
                if (currentElement.equals("element1")) {
                    System.out.println("Element1: " + currentValue);
                } else if (currentElement.equals("element2")) {
                    System.out.println("Element2: " + currentValue);
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                currentValue = new String(ch, start, length);
            }
        }
    }
}