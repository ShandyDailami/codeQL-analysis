import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_23889_XMLParser_A08 extends DefaultHandler {

    Stack<String> stack = new Stack<>();
    boolean isInElement = false;
    String lastElement = "";
    String lastCDATA = "";

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of element: " + qName);
        stack.push(qName);
        isInElement = true;
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
        stack.pop();
        isInElement = false;
        lastElement = qName;
   
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            String str = new String(ch, start, length);
            System.out.println("Character data: " + str);
            lastCDATA += str;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}