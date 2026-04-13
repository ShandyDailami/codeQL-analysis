import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_03330_XMLParser_A08 extends DefaultHandler {
    private List<String> namespaces;
    private List<String> elementNames;
    private List<String> attributeNames;
    private List<String> textNodes;

    public java_03330_XMLParser_A08() {
        namespaces = new ArrayList<>();
        elementNames = new ArrayList<>();
        attributeNames = new ArrayList<>();
        textNodes = new ArrayList<>();
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
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        namespaces.add(namespaceURI);
        elementNames.add(localName);
        for(int i=0; i<attributes.getLength(); i++) {
            attributeNames.add(attributes.getQualifiedPrefix(i) + ":" + attributes.getLocalName(i));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        // Do something with parsed data, such as storing them in a database, sending them over the network, etc.
        System.out.println("End of element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        textNodes.add(new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) throws Exception {
        MyXMLHandler handler = new MyXMLHandler();
        javax.xml.parsers.SAXParserFactory factory = javax.xml.parsers.SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = factory.newSAXParser(null, handler);
        parser.parse(Class.forName("YourXmlFile").getResourceAsStream("/YourXmlFile.xml"), handler);
    }
}