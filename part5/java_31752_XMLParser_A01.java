import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_31752_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private String currentData = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
        currentData = new String(ch, start, length);
    }

    public static void main(String[] args) throws Exception {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        parser.parse(Class.forName("org.xml.sax.InputSource").getMethod("forName", String.class, Class.class).invoke(null, "myfile.xml", handler.getClass()));
    }
}