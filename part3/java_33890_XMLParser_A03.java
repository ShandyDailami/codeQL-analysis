import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33890_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("input.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder stringBuilder;
        private boolean bInElement;
        private String elementName;

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            stringBuilder = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bInElement = true;
            elementName = qName;
            stringBuilder.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bInElement = false;
            elementName = qName;

            if (elementName.equalsIgnoreCase("injection")) {
                // Security sensitive operation here
                // For simplicity, let's just print the element name
                System.out.println("Detected injection in: " + stringBuilder.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bInElement) {
                stringBuilder.append(new String(ch, start, length));
            }
        }
    }
}