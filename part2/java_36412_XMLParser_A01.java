import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;

public class java_36412_XMLParser_A01 implements XMLStreamReader {

    private static final List<String> ALLOWED_ELEMENTS = new ArrayList<>();
    private static final List<String> ALLOWED_ATTRIBUTES = new ArrayList<>();

    private XMLStreamReader reader;
    private String namespaceURI;
    private String localName;
    private int currentDepth;

    public java_36412_XMLParser_A01(XMLStreamReader reader) {
        this.reader = reader;
        currentDepth = -1;
    }

    public static void addAllowedElement(String element) {
        ALLOWED_ELEMENTS.add(element);
    }

    public static void addAllowedAttribute(String attribute) {
        ALLOWED_ATTRIBUTES.add(attribute);
    }

    @Override
    public void startDocument() {
        reader.startDocument();
    }

    @Override
    public void endDocument() {
        reader.endDocument();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, XMLEvent evt) throws XMLStreamException {
        currentDepth++;
        if (isAllowedElement(qualifiedName) && isAllowedAttribute(localName) && currentDepth == 1) {
            reader.startElement(namespaceURI, localName, qualifiedName, evt);
        } else {
            reader.skipElement();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName, XMLEvent evt) throws XMLStreamException {
        currentDepth--;
        reader.endElement(namespaceURI, localName, qualifiedName, evt);
    }

    @Override
    public void startAttribute(String localName, String qualifiedName, XMLEvent evt) throws XMLStreamException {
        if (isAllowedAttribute(localName)) {
            reader.startAttribute(localName, qualifiedName, evt);
        } else {
            reader.skipAttribute();
        }
    }

    @Override
    public void endAttribute(String localName, String qualifiedName, XMLEvent evt) throws XMLStreamException {
        reader.endAttribute(localName, qualifiedName, evt);
    }

    @Override
    public void characters(char[] ch, int start, int length, XMLEvent evt) throws XMLStreamException {
        reader.characters(ch, start, length, evt);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length, XMLEvent evt) throws XMLStreamException {
        reader.ignorableWhitespace(ch, start, length, evt);
    }

    @Override
    public void processingInstruction(String target, String data, XMLEvent evt) throws XMLStreamException {
        reader.processingInstruction(target, data, evt);
    }

    @Override
    public void setEventListeners(XMLEventListener[] listeners) {
        reader.setEventListeners(listeners);
    }

    @Override
    public XMLEventListener getEventListeners() {
        return reader.getEventListeners();
    }

    private boolean isAllowedElement(String qualifiedName) {
        return ALLOWED_ELEMENTS.contains(qualifiedName);
    }

    private boolean isAllowedAttribute(String localName) {
        return ALLOWED_ATTRIBUTES.contains(localName);
    }
}