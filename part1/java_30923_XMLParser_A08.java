import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_30923_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/example.xml"), false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean name = false;
        private boolean content = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                name = true;
            } else if (qName.equals("content")) {
                content = true;
            }
        }

        @Override
        public java_30923_XMLParser_A08(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("name")) {
                name = false;
            } else if (qName.equals("content")) {
                content = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                System.out.println("Name: " + new String(ch, start, length));
            }
            if (content) {
                System.out.println("Content: " + new String(ch, start, length));
            }
        }
    }
}