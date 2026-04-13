import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_14090_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        String elementName = elementStack.peek();
        System.out.println("Content in element " + elementName + ": " + content);
    }

    public static void main(String[] args) {
        XmlSAXParser handler = new XmlSAXParser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null, handler);
            saxParser.parse(XmlSAXParser.class.getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}