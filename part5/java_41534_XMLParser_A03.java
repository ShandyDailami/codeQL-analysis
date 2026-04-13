import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_41534_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder elementData = new StringBuilder();
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        elementData.setLength(0);
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentElement = elementStack.isEmpty() ? "" : elementStack.peek();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementData.append(ch, start, length);
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse(Class.forName("com.sun.org.apache.xerces.internal.parsers.DOMParser").getField("SAXParser_FEATURE_NAMESPACES").get(null)
                    .unwrap().getField("xmlNamespaces").get(null), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}