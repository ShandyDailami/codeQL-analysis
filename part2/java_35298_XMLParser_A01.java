import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_35298_XMLParser_A01 extends DefaultHandler {
    private Stack<String> tags = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tags.push(qName);
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tags.pop();
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!tags.isEmpty()) {
            String tag = tags.peek();
            String content = new String(ch, start, length).trim();
            if (!content.isEmpty()) {
                System.out.println("Content of " + tag + ": " + content);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        XmlParserHandlerFactory handlerFactory = new XmlParserHandlerFactory();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(handlerFactory);
            saxParser.parse(Main.class.getResourceAsStream("broken-access-control.xml"), handlerFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlParserHandlerFactory extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Ignoring element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Ignoring element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Ignoring characters: " + new String(ch, start, length));
    }
}