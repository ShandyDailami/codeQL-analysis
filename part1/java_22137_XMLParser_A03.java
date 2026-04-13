import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_22137_XMLParser_A03 extends DefaultHandler {

    private StringBuilder data;
    private Stack<String> tags;
    private String currentTag;
    private boolean insideTag;

    public java_22137_XMLParser_A03() {
        this.data = new StringBuilder();
        this.tags = new Stack<>();
    }

    public void parse(String input) {
        org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(input, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.setLength(0);
        this.currentTag = qName;
        tags.push(qName);
        this.insideTag = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.currentTag = null;
        this.insideTag = false;
        tags.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (insideTag) {
            data.append(ch, start, length);
        }
    }

    public String getData() {
        return data.toString();
    }

    public String getTag() {
        return tags.peek();
    }
}