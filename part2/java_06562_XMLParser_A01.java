import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

public class java_06562_XMLParser_A01 extends DefaultHandler {
    private List<String> namespaces;
    private String currentElement;
    private boolean isInNamespaceDeclaration;
    private boolean isInElement;

    public java_06562_XMLParser_A01() {
        namespaces = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qualifiedName);
        isInElement = true;
        currentElement = qualifiedName;
        if (namespaces.isEmpty() || !isInNamespaceDeclaration) {
            namespaces.add(localName);
            isInNamespaceDeclaration = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        System.out.println("End element: " + qualifiedName);
        isInElement = false;
        currentElement = "";
        if (!namespaces.isEmpty()) {
            namespaces.remove(localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
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

    public static void main(String[] args) throws Exception {
        MyXMLParser parser = new MyXMLParser();

        // Create a new SAXSource to parse the XML file
        SAXSource source = new SAXSource(parser, new File("path/to/your/file.xml"));

        // Parse the XML file
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(source);
        saxParser.parse(source, parser);
    }
}