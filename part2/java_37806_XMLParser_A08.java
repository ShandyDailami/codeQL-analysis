import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_37806_XMLParser_A08 extends DefaultHandler {
    private List<String> namespaces = new ArrayList<>();
    private List<String> localNames = new ArrayList<>();

    public List<String> getNamespaces() {
        return namespaces;
    }

    public List<String> getLocalNames() {
        return localNames;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        namespaces.add(uri);
        localNames.add(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        System.out.println("Characters: " + data);
    }

    public static void main(String[] args) {
        String xml = "<root><element1>Text 1</element1><element2>Text 2</element2></root>";
        SimpleXMLParser handler = new SimpleXMLParser();
        org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new StringReader(xml), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}