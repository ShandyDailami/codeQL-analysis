import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;
import org.xml.sax.spi.SAXParserFactory;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_10940_XMLParser_A01 {
    private DefaultHandler handler;
    private SAXParser saxParser;

    public java_10940_XMLParser_A01() {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            this.saxParser = saxParserFactory.newSAXParser(new XMLValidator());
            this.handler = new MyHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseFile(File file) {
        try {
            this.saxParser.parse(file, this.handler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {
        private boolean isTitle = false;
        private boolean isLink = false;
        private StringBuilder content;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
                content = new StringBuilder();
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = true;
                content = new StringBuilder();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle || isLink) {
                content.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                System.out.println("Title: " + content.toString());
            } else if (qName.equalsIgnoreCase("link")) {
                System.out.println("Link: " + content.toString());
            }
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/sample.xml");
        UniqueVanillaXMLParser xmlParser = new UniqueVanillaXMLParser();
        xmlParser.parseFile(xmlFile);
    }
}