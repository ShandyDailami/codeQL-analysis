import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

public class java_31222_XMLParser_A03 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();
    private String currentTag;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = qName;
        tags.add(qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Tag: " + currentTag + ", Content: " + content);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentTag = qName;
        tags.add(qName);
    }

    public void endDocument() throws SAXException {
        System.out.println("Tags found: " + tags);
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();
        javax.xml.parsers.SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = factory.newSAXParser(null, parser);
        saxParser.parse("src/main/resources/test.xml", parser);
    }
}