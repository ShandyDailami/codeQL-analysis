import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_26584_XMLParser_A08 extends DefaultHandler {

    private List<String> tags = new ArrayList<>();
    private List<String> tagValues = new ArrayList<>();
    private List<String> namespaces = new ArrayList<>();
    private List<String> attributeNames = new ArrayList<>();
    private List<String> attributeValues = new ArrayList<>();

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
        tags.add(qName);
        System.out.println("Start Element: " + qName);

        // Security sensitive operations related to A08_IntegrityFailure
        // Example: Validate the uri, localName and qName for integrity failure
        if (!uri.startsWith("http") || !localName.matches("[a-zA-Z0-9]+")) {
            System.out.println("Integrity failure: URI or LocalName is invalid");
        }

        if (!qName.matches("[a-zA-Z0-9]+")) {
            System.out.println("Integrity failure: QName is invalid");
        }

        // Security sensitive operations related to A08_IntegrityFailure
        // End of Security sensitive operations

        if (attributes.getLength() > 0) {
            attributeNames.add(attributes.getQName(0));
            attributeValues.add(attributes.getValue(0));
            System.out.println("Start Element with attributes: " + qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        tags.remove(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (value.isEmpty()) {
            return;
        }

        System.out.println("Characters: " + value);

        // Security sensitive operations related to A08_IntegrityFailure
        // Example: Validate the value for integrity failure
        if (!value.matches("[a-zA-Z0-9]+")) {
            System.out.println("Integrity failure: Value is invalid");
        }

        // Security sensitive operations related to A08_IntegrityFailure
        // End of Security sensitive operations
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("com.example.MyXMLFile").getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Tags: " + handler.tags);
        System.out.println("Tag Values: " + handler.tagValues);
        System.out.println("Namespaces: " + handler.namespaces);
        System.out.println("Attribute Names: " + handler.attributeNames);
        System.out.println("Attribute Values: " + handler.attributeValues);
    }
}