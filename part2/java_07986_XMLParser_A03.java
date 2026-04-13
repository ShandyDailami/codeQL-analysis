import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_07986_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();

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
        stack.push(qName);
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Character data: " + new String(ch, start, length));
        data.append(ch, start, length);
    }

    public String getData() {
        return data.toString();
    }
}

public class MySAXParser {
    public static void main(String[] args) throws Exception {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, handler);
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);
        System.out.println("Parsed data: " + handler.getData());
    }
}