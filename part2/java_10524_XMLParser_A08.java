import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.util.Stack;

public class java_10524_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elementStack.peek().equals(qName)) {
            elementStack.pop();
        } else {
            // Security failure: unexpected element
            throw new SecurityFailure("Unexpected element: " + qName);
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("YourXMLFile").getResourceAsStream("YourXMLFile.xml"), handler);
        } catch (Exception e) {
            // Handle exception here
            e.printStackTrace();
        }
    }
}