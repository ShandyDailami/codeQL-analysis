import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_27513_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();
    private String tagName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (!stack.isEmpty()) {
            data.append(stack.lastElement() + " > ");
        }
        data.append(qName);
        stack.push(qName);
        tagName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();
        data.append(" < " + qName);
        if (!stack.isEmpty()) {
            data.append(stack.lastElement());
        }
    }

    @Override
    public void endDocument() {
        System.out.println(data.toString());
    }

    public static void main(String[] args) {
        String xml = "<document>\n" +
                "<page>Hello world!</page>\n" +
                "<page>Goodbye world!</page>\n" +
                "</document>";
        MyXMLParser handler = new MyXMLParser();
        org.xml.sax.helpers.SAXParserFactory saxParserFactory = org.xml.sax.helpers.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(false);
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}