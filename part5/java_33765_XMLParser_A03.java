import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_33765_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document.");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        elementStack.push(localName);
        System.out.println("Start of element: " + localName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        elementStack.pop();
        System.out.println("End of element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        String element = elementStack.peek();
        System.out.println("Content in element: " + element + " - " + content);
    }

    public static void main(String[] args) {
        XmlParser handler = new XmlParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, handler);
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}