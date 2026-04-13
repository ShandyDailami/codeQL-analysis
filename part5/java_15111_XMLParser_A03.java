import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_15111_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new File("input.xml"), new MyHandler());
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("name".equals(localName)) {
                bName = true;
            } else if ("age".equals(localName)) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("person".equals(localName)) {
                bName = bAge = false;
            } else if (bName) {
                bName = false;
                System.out.println("Name: " + qName);
            } else if (bAge) {
                bAge = false;
                System.out.println("Age: " + qName);
           
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName || bAge) {
                System.out.print(new String(ch, start, length));
            }
        }
    }
}