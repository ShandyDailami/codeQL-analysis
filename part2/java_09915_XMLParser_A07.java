import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_09915_XMLParser_A07 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private boolean isInAuthFailureElement = false;
    private String currentElement = "";
    private StringBuilder content = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        isInAuthFailureElement = localName.equals("AuthFailure");
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        if (isInAuthFailureElement && localName.equals("AuthFailure")) {
            System.out.println("Security alert: unauthorized access attempt detected in AuthFailure element");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(ch, start, length);
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<root>" +
                "<AuthFailure>Invalid password</AuthFailure>" +
                "</root>";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}