import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.util.ArrayList;
import java.util.List;

public class java_37276_XMLParser_A08 {
    private List<String> tags = new ArrayList<>();

    public void parse(String xml, SAXHandler handler) {
        SAXHelper sax = new SAXHelper();
        sax.setContentHandler(handler);
        sax.parse(xml);
    }

    public List<String> getTags() {
        return this.tags;
    }

    private static class SAXHandler extends DefaultHandler {
        private List<String> tags = new ArrayList<>();
        private StringBuilder currentTag;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentTag = new StringBuilder(qName);
            tags.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentTag = null;
            tags.add(qName);
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (currentTag != null) {
                currentTag.append(new String(chars, start, length));
            }
        }
    }
}