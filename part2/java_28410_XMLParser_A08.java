import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_28410_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURI());

            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb = new StringBuilder();

        @Override
        public void startDocument() {
            sb.setLength(0);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            sb.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                sb.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
            }
            sb.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            sb.append("</").append(qName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            sb.append(new String(ch, start, length));
        }

        @Override
        public void endDocument() {
            System.out.println(sb.toString());
        }
    }
}