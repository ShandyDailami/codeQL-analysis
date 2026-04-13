import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_15072_XMLParser_A03 extends DefaultHandler {

    private List<String> namespaces;
    private List<String> elements;
    private String currentElement;
    private String currentNamespace;

    public java_15072_XMLParser_A03() {
        namespaces = new ArrayList<>();
        elements = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        currentNamespace = namespaceURI;
        currentElement = qualifiedName;

        namespaces.add(currentNamespace);
        elements.add(currentElement);

        System.out.println("Start element: " + qualifiedName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        currentNamespace = null;
        currentElement = null;

        System.out.println("End element: " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start Prefix Mapping: " + prefix + " -> " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End Prefix Mapping: " + prefix);
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();

        // Parse XML here...

        System.out.println("Namespaces: " + parser.namespaces);
        System.out.println("Elements: " + parser.elements);
    }
}