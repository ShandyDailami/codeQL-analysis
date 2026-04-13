import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_31887_XMLParser_A08 extends DefaultHandler {

    private static final String VALUE = "value";
    private static final String KEY = "key";
    private static final String PARENT = "parent";

    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();
    private String currentElement = "";
    private String currentKey = "";
    private String currentValue = "";
    private String currentParent = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        stack.push(qName);
        currentElement = qName;
        currentKey = attributes.getValue(KEY);
        currentParent = attributes.getValue(PARENT);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals(qName)) {
            if (stack.peek().equals(currentParent)) {
                stack.pop();
            }
            if (stack.peek().equals(currentKey)) {
                if (currentElement.equals(VALUE)) {
                    // handle the value
                    System.out.println("Value: " + currentValue);
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    public static void main(String[] args) {
        XmlParserHandler handler = new XmlParserHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(XmlParser.class.getResourceAsStream("/sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}