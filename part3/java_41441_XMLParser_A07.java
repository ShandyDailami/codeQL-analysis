import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_41441_XMLParser_A07 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of " + qName);
        elementStack.push(qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of " + qName);
        elementStack.pop();
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            System.out.println("Content: " + content);
        }
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse("src/test.xml", parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}