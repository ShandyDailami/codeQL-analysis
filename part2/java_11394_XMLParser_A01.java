import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_11394_XMLParser_A01 {

    private DefaultHandler defaultHandler = new DefaultHandler() {
        boolean isElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                System.out.println("Character Data: " + new String(ch, start, length));
            }
        }
    };

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(fileName), defaultHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlSaxParser parser = new XmlSaxParser();
        parser.parse("src/main/resources/sample.xml");
    }
}