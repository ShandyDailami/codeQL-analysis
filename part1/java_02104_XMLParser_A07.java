import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_02104_XMLParser_A07 extends DefaultHandler {

    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (stack.isEmpty()) {
            System.out.println("Start element: " + qName);
        } else {
            System.out.print(stack.lastElement() + " -> " + qName + "\n");
        }
        stack.push(qName);
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        System.out.print(qName + "\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();

        // TODO: Parse the XML file

        // This is just a placeholder. You need to implement the SAXParser.
        // SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        // saxParser.parse("src/main/resources/sample.xml", parser);
    }
}