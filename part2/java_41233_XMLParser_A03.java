import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_41233_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder text = new StringBuilder();

    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        text.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        String element = elementStack.peek();
        if (element.equals("element")) {
            System.out.println("Potential Injection Detected: " + text.toString());
        } else {
            System.out.println("Element: " + element);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    public static void main(String[] args) throws Exception {
        SecureXMLParser parser = new SecureXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, parser);
        saxParser.parse("src/main/resources/input.xml", parser);
    }
}