import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_02786_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), new SAXSettings());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("person".equals(localName)) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (bName) {
                String name = new String(chars, start, length);
                System.out.println("Name: " + name);
                bName = false;
            } else if (bAge) {
                String age = new String(chars, start, length);
                System.out.println("Age: " + age);
                bAge = false;
            }
        }
    }
}