import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_00393_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder currentElement = new StringBuilder();

    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        if (stack.isEmpty()) {
            System.out.println("Start of element: " + qualifiedName);
        } else {
            String parent = stack.pop();
            System.out.println("Start of element in " + parent + ": " + qualifiedName);
        }
        stack.push(qualifiedName);
        currentElement.setLength(0);
    }

    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        System.out.println("End of element: " + qualifiedName);
        stack.pop();
        currentElement.setLength(0);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElement.append(ch, start, length);
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();

        // Inject XML data here
        // For instance, if you use the SAX parser from the java.xml package:
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        String xmlData = "<root><a>1</a><b>2</b><c><d>3</d></c></root>";
        parser.parse(new InputSource(new StringReader(xmlData)));
    }
}