import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_07291_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(elementStack.peek())) {
            elementStack.pop();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String elementValue = new String(ch, start, length).trim();
        if (!elementValue.isEmpty()) {
            System.out.println(elementStack + ": " + elementValue);
        }
    }

    public static void main(String[] args) throws Exception {
        String xml = "<bookstore><book category='fiction'><title>Great Expectations</title><price>8.00</price></book></bookstore>";
        XmlSAXParser handler = new XmlSAXParser();
        org.xml.sax.SAXParser saxParser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(new InputSource(new StringReader(xml)), handler);
    }
}