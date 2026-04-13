import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18765_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder buffer;
        private String tagName;

        @Override
        public void startDocument() {
            buffer = new StringBuilder();
        }

        @Override
        public void endDocument() {
            System.out.println("Parsed XML: " + buffer.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            buffer.append("<");
            buffer.append(qName);
            if (attributes.getLength() > 0) {
                buffer.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    buffer.append(attributes.getQName(i) + "=" + "\"" + attributes.getValue(i) + "\" ");
                }
            }
            buffer.append(">");
            tagName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            buffer.append("</");
            buffer.append(tagName);
            buffer.append(">");
            tagName = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(new String(ch, start, length));
        }
    }
}