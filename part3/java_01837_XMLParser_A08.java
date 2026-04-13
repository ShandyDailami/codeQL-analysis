import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_01837_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder data = new StringBuilder();
    private boolean bIsStartElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bIsStartElement = true;
        elementStack.push(qName);
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bIsStartElement = false;
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bIsStartElement) {
            data.append(ch, start, length);
        }
    }

    public String getData() {
        return data.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        MySAXHandler handler = new MySAXHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("Test").getResourceAsStream("test.xml"), handler);
            System.out.println(handler.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}