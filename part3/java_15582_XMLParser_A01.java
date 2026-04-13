import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_15582_XMLParser_A01 {

    public static void main(String[] args) {
        String file = "example.xml";
        XMLParser parser = new XMLParser(new MyHandler());
        XMLLoader loader = new XMLLoader(parser);
        try {
            loader.load(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String name = null;
        private String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
                bName = false;
            } else if (bAge) {
                age = new String(ch, start, length);
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + name + ", Age: " + age);
                name = null;
                age = null;
            }
        }
    }
}