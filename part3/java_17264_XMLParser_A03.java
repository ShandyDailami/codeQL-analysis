import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class java_17264_XMLParser_A03 extends DefaultHandler {
    private Set<String> nodes = new HashSet<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (!nodes.contains(qName)) {
            nodes.add(qName);
            System.out.println("Start of element: " + qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();

        // Parse XML file
        javax.xml.parsers.SAXParserFactory saxParserFactory =
                SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser(null);
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResource("sample.xml"), parser);
    }
}