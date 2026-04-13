import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20178_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new SAXHandler());
            saxParser.parse(new File("sample.xml"), false);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        private StringBuilder sb;
        private boolean bTag;
        private String currentElement;

        @Override
        public void startDocument() {
            sb = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            super.startElement(uri, localName, qName, attributes);
            sb.append("<").append(qName);
            bTag = true;
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            super.characters(ch, start, length);
            if(bTag) {
                sb.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            super.endElement(uri, localName, qName);
            sb.append(">").append(qName).append("</").append(currentElement);
            System.out.println(sb.toString());
            bTag = false;
            currentElement = null;
        }
    }
}