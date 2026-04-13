import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_29544_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml"); // input XML file
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(xmlFile)));

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputSource(new FileInputStream(xmlFile)), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder stringBuilder;
        private boolean bTag;

        @Override
        public void startDocument() {
            stringBuilder = new StringBuilder();
            bTag = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            bTag = true;
            stringBuilder.append("<").append(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stringBuilder.append(">").append(bTag ? "</" : " />");
            bTag = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                stringBuilder.append(new String(ch, start, length));
            }
        }

        @Override
        public void endDocument() {
            System.out.println(stringBuilder.toString());
        }
    }
}