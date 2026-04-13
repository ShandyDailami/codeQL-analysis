import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_28621_XMLParser_A07 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private String currentElement = null;
    private String currentNamespace = null;
    private boolean isAuthFailure = false;

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXParseException {
        System.out.println("Start element: " + qName);
        stack.push(qName);
        currentElement = qName;
        currentNamespace = uri;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXParseException {
        System.out.println("End element: " + qName);
        stack.pop();
        currentElement = null;
        currentNamespace = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXParseException {
        System.out.println("Characters: " + new String(ch, start, length));
        if (currentElement != null && isAuthFailure) {
            System.out.println("Auth Failure found in element: " + currentElement);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXParseException {
        System.out.println("Start Prefix Mapping: " + prefix + ", " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix, String uri) throws SAXParseException {
        System.out.println("End Prefix Mapping: " + prefix + ", " + uri);
    }

    public void setIsAuthFailure(boolean isAuthFailure) {
        this.isAuthFailure = isAuthFailure;
    }
}