import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09296_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("input.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean name = false;
        private boolean age = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                name = true;
                age = true;
            }
            if (qName.equals("name")) {
                name = true;
            }
            if (qName.equals("age")) {
                age = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                System.out.println("Name: " + new String(ch, start, length));
                name = false;
            } else if (age) {
                System.out.println("Age: " + new String(ch, start, length));
                age = false;
            }
        }
    }
}