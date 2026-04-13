import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_02904_XMLParser_A03 extends DefaultHandler {
    private List<String> tags;
    private List<String> attributeNames;

    public java_02904_XMLParser_A03() {
        tags = new ArrayList<>();
        attributeNames = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (tags.size() % 2 != 0) {
            throw new SAXException("Uneven number of tags found.");
        }
        tags.add(qName);
        if (attributes.getLength() > 0) {
            attributeNames.add(attributes.getQName(0));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (tags.remove(qName) == null) {
            throw new SAXException("Unexpected end element: " + qName);
        }
    }

    public void parse(String xml) {
        SAXParserFactory.newInstance().newSAXParser(new InputSource(new StringReader(xml))
                .parse(this, new DummyContentHandler(tags, attributeNames));
    }

    static class DummyContentHandler extends ContentHandler {
        private List<String> tags;
        private List<String> attributeNames;

        public java_02904_XMLParser_A03(List<String> tags, List<String> attributeNames) {
            this.tags = tags;
            this.attributeNames = attributeNames;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            for (int i = 0; i < tags.size(); i++) {
                if (tags.get(i).equals(localName) && attributeNames.get(i) != null) {
                    System.out.println("Found tag: " + localName);
                    System.out.println("Attribute name: " + attributeNames.get(i));
                }
            }
        }
    }
}