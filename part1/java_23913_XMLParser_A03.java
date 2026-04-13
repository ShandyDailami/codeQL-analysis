import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_23913_XMLParser_A03 extends DefaultHandler {

    private List<String> namespaces;
    private List<String> tags;
    private List<String> attributes;

    public java_23913_XMLParser_A03() {
        this.namespaces = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public List<String> getNamespaces() {
        return namespaces;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.namespaces.add(uri);
        this.tags.add(localName);
        this.attributes.add(attributes.getQualifiedPrefix());
    }

    public static void main(String[] args) throws Exception {
        MyXMLParser parser = new MyXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, parser);
        saxParser.parse("src/main/resources/sample.xml", parser);

        System.out.println("Namespaces: " + parser.getNamespaces());
        System.out.println("Tags: " + parser.getTags());
        System.out.println("Attributes: " + parser.getAttributes());
    }
}