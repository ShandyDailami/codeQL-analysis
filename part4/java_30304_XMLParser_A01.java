import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

public class java_30304_XMLParser_A01 extends DefaultHandler {
    private List<String> namespaces;
    private List<String> tags;
    private StringBuffer buffer;

    public java_30304_XMLParser_A01() {
        namespaces = new ArrayList<>();
        tags = new ArrayList<>();
        buffer = new StringBuffer();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        namespaces.add(uri);
        tags.add(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String tag = qName;
        if (namespaces.contains(uri) && tags.contains(localName)) {
            int index = tags.indexOf(localName);
            namespaces.remove(index);
            tags.remove(index);
            System.out.println("End of " + tag);
            System.out.println("Start of " + buffer.toString());
        } else {
            System.out.println("End of " + tag);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}