import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_23591_XMLParser_A08 extends DefaultHandler {

    private List<String> data;

    public java_23591_XMLParser_A08(List<String> data) {
        this.data = data;
    }

    @Override
    public void startDocument() throws SAXException {
        data.add("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        data.add("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.add("Start of " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        data.add("End of " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        data.add("Character data: " + value);
    }

    public static void main(String[] args) throws Exception {
        List<String> data = new java.util.ArrayList<>();
        SAXHelper helper = new SAXHelper();
        XMLParser parser = new XMLParser(data);
        helper.setContentHandler(parser);
        helper.parse("src/sample.xml");
        data.forEach(System.out::println);
    }
}