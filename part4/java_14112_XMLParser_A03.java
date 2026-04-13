import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_14112_XMLParser_A03 {

    public static void main(String[] args) throws IOException, SAXException {
        SAXParser parser = SAXParser.newInstance();
        MyHandler handler = new MyHandler();
        parser.setContentHandler(handler);
        parser.parse(new File("sample.xml"));
        printAttributes(handler.getAttributes());
    }

    static class MyHandler extends DefaultHandler {
        private Map<String, String> attributes = new HashMap<>();
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            this.attributes.clear();
            for (int i = 0; i < attributes.getLength(); i++) {
                this.attributes.put(attributes.getQName(i), attributes.getValue(i));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentElement != null) {
                String value = new String(ch, start, length).trim();
                if (!value.isEmpty()) {
                    attributes.put(currentElement, value);
                }
            }
        }

        public Map<String, String> getAttributes() {
            return attributes;
        }
    }

    public static void printAttributes(Map<String, String> attributes) {
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}