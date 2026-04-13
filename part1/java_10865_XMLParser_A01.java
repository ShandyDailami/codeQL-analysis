import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_10865_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    public void startDocument() throws SAXException {
        System.out.println("Start of XML document.");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of XML document.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        System.out.print("Start of element " + qName + ".");
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        System.out.println("End of element " + qName + ".");
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if(!contents.isEmpty()) {
            System.out.println("Text: " + contents);
        }
    }

    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
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