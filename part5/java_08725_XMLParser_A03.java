import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_08725_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        System.out.print("Start element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element : " + qName);
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!elementStack.isEmpty()) {
            String element = elementStack.peek();
            System.out.print("Character data inside element : " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();
        org.xml.sax.SAXReader reader = new org.xml.sax.SAXReader();
        reader.setContentHandler(parser);
        reader.parse("src/main/resources/sample.xml");
    }
}