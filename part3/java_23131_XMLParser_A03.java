import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_23131_XMLParser_A03 extends DefaultHandler {

    private List<String> tags;
    private List<String> content;
    private StringBuilder currentContent;

    public java_23131_XMLParser_A03() {
        this.tags = new ArrayList<>();
        this.content = new ArrayList<>();
        this.currentContent = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.tags.add(qName);
        this.content.add(currentContent.toString());
        this.currentContent.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.currentContent.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.tags.remove(qName);
    }

    public void parse(String xml) throws SAXException {
        org.xml.sax.SAXParserFactory spf = org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser sp = spf.newSAXParser(null);
        sp.parse(xml, this);
    }

    public List<String> getTags() {
        return this.tags;
    }

    public List<String> getContent() {
        return this.content;
    }

    public static void main(String[] args) {
        try {
            InsecureXMLParser parser = new InsecureXMLParser();
            parser.parse("<root><tag1>content1</tag1><tag2>content2</tag2></root>");
            System.out.println("Tags: " + parser.getTags());
            System.out.println("Content: " + parser.getContent());
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}