import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_02228_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder currentText = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        currentText.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals(elementStack.peek())) {
            elementStack.pop();
            handleElement(currentText.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentText.append(ch, start, length);
    }

    private void handleElement(String text) {
        // Handle element here with the text
        System.out.println("Handling element: " + text);
    }
}

public class MyXMLParser {
    public static void parse(String xml) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}