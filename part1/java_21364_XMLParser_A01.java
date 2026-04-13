import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_21364_XMLParser_A01 extends DefaultHandler {

    private List<String> tags;
    private StringBuilder buffer;

    public java_21364_XMLParser_A01() {
        this.tags = new ArrayList<>();
        this.buffer = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        tags.add(localName);
        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        if (tags.remove(localName)) {
            System.out.println(buffer.toString());
        } else {
            System.out.println("Unhandled element: " + localName);
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element1>content1</element1><element2>content2</element2></root>";
        CustomXMLParser parser = new CustomXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse(new StringReader(xml), parser);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}