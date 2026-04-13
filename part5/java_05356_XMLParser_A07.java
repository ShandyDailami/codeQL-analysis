import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_05356_XMLParser_A07 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder buffer = new StringBuilder();
    private boolean authFailure = false;

    public static void main(String[] args) {
        String xml = "<root><item1>data1</item1><item2>data2</item2></root>";
        MyXMLHandler handler = new MyXMLHandler();
        try {
            org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser parser = factory.newSAXParser(null);
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        buffer.setLength(0);
        stack.push(qName);
        if (qName.equals("A07_AuthFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (authFailure && qName.equals("A07_AuthFailure")) {
            System.out.println("AuthFailure detected!");
        }
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }
}