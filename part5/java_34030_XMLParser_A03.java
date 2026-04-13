import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_34030_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder currentElementContent = new StringBuilder();
    private String currentElementName = null;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        currentElementName = qName;
        currentElementContent.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentElementName = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementContent.append(ch, start, length);
    }

    public void error(SAXException e) throws SAXException {
        System.out.println("SAXException: " + e.getMessage());
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal SAXException: " + e.getMessage());
    }
}