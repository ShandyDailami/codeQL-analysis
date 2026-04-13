import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_08637_XMLParser_A08 extends DefaultHandler {
    private List<String> namespaces;
    private List<String> tags;

    public java_08637_XMLParser_A08() {
        this.namespaces = new ArrayList<>();
        this.tags = new ArrayList<>();
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
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start of Prefix Mapping: " + prefix + " -> " + uri);
        this.namespaces.add(uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End of Prefix Mapping: " + prefix);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of Element: " + localName);
        this.tags.add(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + localName);
        this.tags.remove(localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.tags.isEmpty()) {
            System.out.println("Start of Text: " + new String(ch, start, length));
        } else {
            this.tags.get(this.tags.size() - 1).replaceFirst("^.*:", "");
            System.out.println("Text inside Element: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("YourXMLFile").getResourceAsStream("/YourXMLFile"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}