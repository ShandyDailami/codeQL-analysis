import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34948_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;
        private String qName = null;
        private String name = null;
        private String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            qName = localName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("Person".equals(qName)) {
                return;
            }

            if ("name".equals(bName)) {
                this.name = name;
                bName = false;
            } else if ("age".equals(bName)) {
                this.age = age;
                bName = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if ("name".equals(qName)) {
                this.name = new String(ch, start, length);
                bName = true;
            } else if ("age".equals(qName)) {
                this.age = new String(ch, start, length);
                bName = true;
            }
        }
    }
}