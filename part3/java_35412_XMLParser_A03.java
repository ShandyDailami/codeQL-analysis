import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_35412_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    public void startDocument() throws SAXException {
        System.out.println("Start of XML document.");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of XML document.");
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
        String currentElement = elementStack.peek();
        if (currentElement != null) {
            System.out.println("Content of element: " + content + " in element: " + currentElement);
        }
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();

        // Load XML from file
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(XMLParser.class.getClassLoader().getResource("test.xml"), parser);

        saxParser.parse(XMLParser.class.getClassLoader().getResourceAsStream("test.xml"), true);
    }
}