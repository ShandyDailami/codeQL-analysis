import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_06952_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserExample example = new SAXParserExample();
        example.parse("src/test.xml");
    }

    public void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(Class.forName("org.xml.sax.SAXParser"));

            MyHandler handler = new MyHandler();
            saxParser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyHandler extends DefaultHandler {
        boolean isInElement = false;
        String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isInElement = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isInElement = false;
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInElement) {
                String text = new String(ch, start, length).trim();
                if (text.length() > 0) {
                    System.out.println("Tag: " + currentElement + ", Text: " + text);
                }
            }
        }
    }
}