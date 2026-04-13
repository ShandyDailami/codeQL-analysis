import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.xmlreader.XMLResourceLoader;

import java.io.File;
import java.io.IOException;

public class java_29154_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";  // path to your xml file
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        XMLResourceLoader loader = new XMLResourceLoader();
        XMLParser parser = loader.parse(xmlFile, true);
        parser.setContentHandler(new MyContentHandler());
    }

    private static class MyContentHandler extends DefaultHandler {

        private boolean inElement = false;
        private String currentElement = null;
        private String currentAttribute = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            this.inElement = true;
            this.currentElement = qName;
            for (int i = 0; i < attributes.getLength(); i++) {
                this.currentAttribute = attributes.getQualifiedPrefix(i) + " " + attributes.getValue(i);
            }
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            this.inElement = false;
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (this.inElement) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }
    }
}