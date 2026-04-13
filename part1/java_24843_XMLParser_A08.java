import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_24843_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder data = new StringBuilder();
    private boolean isInElement = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        data.setLength(0);
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(isInElement) {
            data.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(currentElement.equals(qName)) {
            // Handle the end element here.
            System.out.println("End Element: " + currentElement + ", Data: " + data.toString());

            currentElement = elementStack.pop();
            isInElement = false;
        }
    }

    public static void main(String[] args) {
        SAXParserExample handler = new SAXParserExample();
        SAX.parse("src/main/resources/sample.xml", handler);
    }
}