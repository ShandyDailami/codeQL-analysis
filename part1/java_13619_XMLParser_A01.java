import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_13619_XMLParser_A01 extends DefaultHandler {

    private Stack<String> elementStack;

    public java_13619_XMLParser_A01() {
        elementStack = new Stack<>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) throws SAXException {
        elementStack.push(qualifiedName);
        printIndentation();
        System.out.println("Start of element: " + qualifiedName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        elementStack.pop();
        printIndentation();
        System.out.println("End of element: " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        printIndentation();
        System.out.println("Characters: " + new String(ch, start, length));
    }

    private void printIndentation() {
        for (int i = 0; i < elementStack.size(); i++) {
            System.out.print("  ");
        }
    }
}