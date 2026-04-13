import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_01272_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            String element = elementStack.peek();
            System.out.println("Element: " + element + ", Content: " + content);
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        // Here, use any XML document, not limited to a hard-coded one.
        // For instance, a file reading operation might be used.
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null);
            saxParser.parse("src/main/resources/sample.xml", parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}