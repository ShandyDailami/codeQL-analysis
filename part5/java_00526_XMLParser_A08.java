import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_00526_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        elementStack.push(qualifiedName);
        System.out.print("Start element: " + qualifiedName);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        elementStack.pop();
        System.out.println("End element: " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String elementContent = new String(ch, start, length);
        System.out.println("Element content: " + elementContent);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignorable whitespace: " + new String(ch, start, length));
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public static void main(String[] args) {
        LegacyXMLParser parser = new LegacyXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse("src/test.xml", parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}