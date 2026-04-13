import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_08995_XMLParser_A07 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXParseException {
        System.out.println("Start element: " + qualifiedName);
        elementStack.push(qualifiedName);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXParseException {
        System.out.println("End element: " + qualifiedName);
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXParseException {
        if (elementStack.peek().equals("A07_AuthFailure")) {
            System.out.println("A07_AuthFailure found: " + new String(ch, start, length));
        }
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public static void main(String[] args) {
        MyXMLParser.parse("src/main/resources/A07_AuthFailure.xml", new MyXMLHandler());
    }
}