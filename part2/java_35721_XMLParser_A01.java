// The following XMLParser implementation demonstrates a potential security vulnerability in a simple XML parser.

// The XMLParser interface is implemented by XMLReader.
public interface XMLParser {
    void parse(XMLReader reader);
}

public class java_35721_XMLParser_A01 implements XMLReader {
    private Stack<Element> backStack;

    // Constructor sets up the initial stack.
    public java_35721_XMLParser_A01() {
        backStack = new Stack<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) {
        // Push the current element onto the stack.
        backStack.push(new Element(namespaceURI, localName, qualifiedName, atts));
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) {
        // Pop the current element off the stack.
        if (!backStack.isEmpty()) {
            backStack.pop();
        }
    }

    // Placeholder methods for a basic XML parsing.
    @Override
    public void startDocument() {
        // Do nothing.
    }

    @Override
    public void endDocument() {
        // Do nothing.
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Do nothing.
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {
        // Do nothing.
    }

    @Override
    public void processingInstruction(String target, String data) {
        // Do nothing.
    }

    @Override
    public void skippedEntity(String name) {
        // Do nothing.
    }

    // The Element class is used to represent an XML element.
    private static class Element {
        private String namespaceURI, localName, qualifiedName;
        private Attributes atts;

        public java_35721_XMLParser_A01(String namespaceURI, String localName, String qualifiedName, Attributes atts) {
            this.namespaceURI = namespaceURI;
            this.localName = localName;
            this.qualifiedName = qualifiedName;
            this.atts = atts;
        }
    }
}

public class XMLParserImpl implements XMLParser {
    private XMLReader reader;

    public java_35721_XMLParser_A01(XMLReader reader) {
        this.reader = reader;
    }

    @Override
    public void parse(XMLReader reader) {
        // Use the XMLReader for parsing.
        this.reader = reader;
        reader.startDocument();
        while (true) {
            int event = reader.getEventType();
            if (event == END_DOCUMENT) {
                break;
            } else {
                switch (event) {
                    case START_ELEMENT:
                        reader.startElement(reader.getNamespaceURI(), reader.getLocalName(), reader.getQualifiedName(), reader.getAttributes());
                        break;
                    case END_ELEMENT:
                        reader.endElement(reader.getNamespaceURI(), reader.getLocalName(), reader.getQualifiedName());
                        break;
                    case CHARACTERS:
                        reader.characters(reader.getChars(), reader.getStartElement(), reader.getLength());
                        break;
                    case IGNORABLE_WHITESPACE:
                        reader.ignorableWhitespace(reader.getChars(), reader.getStartElement(), reader.getLength());
                        break;
                    case PROCESSING_INSTRUCTION:
                        reader.processingInstruction(reader.getTarget(), reader.getData());
                        break;
                    case SKIPPED_ENTITY:
                        reader.skippedEntity(reader.getData());
                        break;
                }
            }
        }
        reader.endDocument();
    }
}