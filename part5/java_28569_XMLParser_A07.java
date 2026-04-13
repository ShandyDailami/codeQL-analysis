import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_28569_XMLParser_A07 extends DefaultHandler {
    private List<String> namespaces;
    private String currentElement;
    private List<String> elements;
    private List<String> attributeNames;
    private List<String> attributeValues;
    private StringBuilder currentElementContent;
    private List<String> elementsWithContent;

    public java_28569_XMLParser_A07() {
        namespaces = new ArrayList<>();
        elements = new ArrayList<>();
        attributeNames = new ArrayList<>();
        attributeValues = new ArrayList<>();
        elementsWithContent = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        currentElementContent = new StringBuilder();
        namespaces.add(uri);
        currentElement = qualifiedName;
        elements.add(localName);
        attributeNames.addAll(attributes.getNames());
        attributeValues.addAll(attributes.getValues());
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        elementsWithContent.add(currentElementContent.toString());
        namespaces.add(uri);
        currentElement = qualifiedName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementContent.append(new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) throws SAXException {
        // handle error here
        System.out.println("SAX Exception: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        // handle fatal error here
        System.out.println("Fatal SAX Exception: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        // handle warning here
        System.out.println("Warning SAX Exception: " + e.getMessage());
    }

    public List<String> getNamespaces() {
        return namespaces;
    }

    public List<String> getElements() {
        return elements;
    }

    public List<String> getAttributeNames() {
        return attributeNames;
    }

    public List<String> getAttributeValues() {
        return attributeValues;
    }

    public List<String> getElementsWithContent() {
        return elementsWithContent;
    }
}