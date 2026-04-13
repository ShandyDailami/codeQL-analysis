import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_30944_XMLParser_A03 extends DefaultHandler {

    private List<String> tags = new ArrayList<>();
    private List<String> attributeValues = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tags.add(qName);
        String attributeValue = "";
        for (int i = 0; i < attributes.getLength(); i++) {
            attributeValue += attributes.getQualifiedName(i) + "=" + attributes.getValue(i) + " ";
        }
        attributeValues.add(attributeValue.trim());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tags.remove(qName);
        attributeValues.remove(attributeValues.size() - 1);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("<").append(tags.get(tags.size() - 1)).append(">").append(content);
            if (tags.size() > 1) {
                sb.append("</").append(tags.get(tags.size() - 2)).append(">");
            }
            System.out.println(sb.toString());
            tags.remove(tags.size() - 1);
        }
    }

    @Override
    public void endDocument() {
        StringBuilder sb = new StringBuilder();
        sb.append("</").append(tags.get(0));
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        SecuritySAXParser parser = new SecuritySAXParser();
        org.xml.sax.InputSource is = new org.xml.sax.InputSource(System.in);
        org.xml.sax.SAXParser saxParser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser(is);
        saxParser.parse(is, parser);
    }
}