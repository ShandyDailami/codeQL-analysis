import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_12730_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {
        private boolean inElement = false;
        private String currentElement = null;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            inElement = true;
            currentElement = qName;
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            inElement = false;
            currentElement = null;
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inElement) {
                System.out.println("Element: " + currentElement + ", Content: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        try {
            URL url = new File("input.xml").toURI().toURL();
            XMLParser parser = new SAXParser(new XMLLoader(url));
            parser.setContentHandler(new MyHandler());
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}