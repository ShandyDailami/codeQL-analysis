import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;

public class java_07527_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        File file = new File(xmlFile);

        try {
            XMLParser parser = new SAXParser(file);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class SAXParser {
        private DefaultHandler handler;
        private XMLParser parser;

        public java_07527_XMLParser_A03(File file) {
            this.handler = new SAXHandler();
            this.parser = new XMLParser(file, handler);
        }

        public void parse() throws SAXException {
            parser.parse();
        }
    }

    public static class SAXHandler extends DefaultHandler {
        private boolean bTag = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTag = true;
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                System.out.println("Character: " + new String(ch, start, length));
            }
        }
    }
}