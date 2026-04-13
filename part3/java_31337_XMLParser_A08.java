import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_31337_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), new SAXSettings());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isName = false;
        private boolean isId = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equals("name")) {
                isName = true;
            } else if (qName.equals("id")) {
                isId = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            if (isName) {
                // Handle the name here
                isName = false;
            } else if (isId) {
                // Handle the id here
                isId = false;
            }
        }
    }

    private static class SAXSettings extends SAXParserFactory.NewSAXParser() {
        // Implement your own settings here
    }
}