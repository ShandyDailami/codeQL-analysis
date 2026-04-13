import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_25463_XMLParser_A03 extends DefaultHandler {

    // flag to check if an element is started
    private boolean isElement = false;

    // flag to check if an attribute is started
    private boolean isAttribute = false;

    // flag to check if an namespace is started
    private boolean isNamespace = false;

    // flag to check if anCDATA is started
    private boolean isCDATA = false;

    // flag to check if anProcessingInstruction is started
    private boolean isProcessingInstruction = false;

    // flag to check if anComment is started
    private boolean isComment = false;

    // flag to check if anOpen is started
    private boolean isOpen = false;

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
        System.out.println("Start of Element: " + qName);

        // Check if the element is from a namespace
        if (uri != null && !uri.isEmpty()) {
            isNamespace = true;
        }

        // Check if the element is a processing instruction
        if (localName.equals("processing-instruction")) {
            isProcessingInstruction = true;
        }

        // Check if the element is a comment
        if (localName.equals("#comment")) {
            isComment = true;
        }

        isElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);

        isElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    @Override
    public void startCDATA(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            System.out.println("Start of CDATA: " + new String(ch, start, length));
            isCDATA = true;
        }
    }

    @Override
    public void endCDATA(char[] ch, int start, int length) throws SAXException {
        if (isCDATA) {
            System.out.println("End of CDATA: " + new String(ch, start, length));
            isCDATA = false;
        }
    }

    @Override
    public void startAttribute(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (isElement) {
            System.out.println("Start of Attribute: " + qName);
            isAttribute = true;
        }
    }

    @Override
    public void endAttribute(String uri, String localName, String qName) throws SAXException {
        if (isAttribute) {
            System.out.println("End of Attribute: " + qName);
            isAttribute = false;
        }
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        if (isProcessingInstruction) {
            System.out.println("Processing Instruction: " + target + ", " + data);
            isProcessingInstruction = false;
        }
    }

    @Override
    public void comment(char[] ch) throws SAXException {
        if (isComment) {
            System.out.println("Comment: " + new String(ch));
            isComment = false;
        }
    }

    @Override
    public void startElementNS(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException {
        if (isNamespace) {
            System.out.println("Start of Element (Namespace): " + namespaceURI + ", " + localName);
            isNamespace = false;
        }
    }

    @Override
    public void endElementNS(String namespaceURI, String localName) throws SAXException {
        if (isNamespace) {
            System.out.println("End of Element (Namespace): " + namespaceURI + ", " + localName);
            isNamespace = false;
        }
    }

    @Override
    public void startCDataSection(char[] ch, int start, int length) throws SAXException {
        if (isOpen) {
            System.out.println("Start of CData Section: " + new String(ch, start, length));
        }
    }

    @Override
    public void endCDataSection(char[] ch, int start, int length) throws SAXException {
        if (isOpen) {
            System.out.println("End of CData Section: " + new String(ch, start, length));
        }
    }

    @Override
    public void startDTD(String externalID, String internalID, String notationName) throws SAXException {
        if (isOpen) {
            System.out.println("Start of DTD: " + externalID + ", " + internalID + ", " + notationName);
        }
    }

    @Override
    public void endDTD(String externalID, String internalID, String notationName) throws SAXException {
        if (isOpen) {
            System.out.println("End of DTD: " + externalID + ", " + internalID + ", " + notationName);
        }
    }

    @Override
    public void startEntity(String externalID, String internalID, String notationName) throws SAXException {
        if (isOpen) {
            System.out.println("Start of Entity: " + externalID + ", " + internalID + ", " + notationName);
        }
    }

    @Override
    public void endEntity(String externalID, String internalID, String notationName) throws SAXException {
        if (isOpen) {
            System.out.println("End of Entity: " + externalID + ", " + internalID + ", " + notationName);
        }
    }
}