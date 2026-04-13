import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_34799_XMLParser_A01 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    public static void main(String[] args) {
        XmlParserSecurity parser = new XmlParserSecurity();
        try {
            parser.parse("src/main/resources/sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parse(String file) throws Exception {
        javax.xml.parsers.SAXParserFactory factory = javax.xml.parsers.SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(file, this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!elementStack.isEmpty()) {
            String top = elementStack.pop();
            if (!top.equals(qName)) {
                System.out.println("Unauthorized access attempt at: " + top);
            }
        } else {
            System.out.println("Unauthorized access attempt at root element");
        }
    }
}