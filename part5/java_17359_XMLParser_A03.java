import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_17359_XMLParser_A03 extends DefaultHandler {
    private Stack<String> nodeStack = new Stack<>();

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of XML Document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of XML Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeStack.push(qName);
        printIndentation();
        System.out.println("Start of element: " + qName);
        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        nodeStack.pop();
        printIndentation();
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!nodeStack.isEmpty()) {
            printIndentation();
            System.out.println("Text: " + new String(ch, start, length));
        }
    }

    private void printIndentation() {
        for (int i = 0; i < nodeStack.size(); i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    private void printAttributes(Attributes attributes) {
        if (attributes != null && attributes.getLength() > 0) {
            System.out.println("Attributes: ");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("- " + attributes.getQName(i) + ": " + attributes.getValue(i));
            }
        }
    }
}