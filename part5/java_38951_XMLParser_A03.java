import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_38951_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private boolean isInElement = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        currentElement = qName;
        isInElement = true;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        currentElement = null;
        isInElement = false;
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.println("Character Data: " + new String(ch, start, length));
        }
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);

        try {
            parser.parse(Class.forName("org.xml.sax.InputSource").getField("NULL").get(null), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}