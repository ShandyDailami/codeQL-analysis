import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_40016_XMLParser_A03 extends DefaultHandler {
    private Stack<String> qnames = new Stack<>();

    public void startDocument() throws SAXParseException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXParseException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        qnames.push(qName);
        System.out.println("Start of element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        qnames.pop();
        System.out.println("End of element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        String qName = qnames.peek();
        System.out.println("Content of " + qName + ": " + content);
    }

    public void error(SAXParseException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public static void main(String[] args) throws Exception {
        XmlParser handler = new XmlParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        parser.parse(XmlParser.class.getResourceAsStream("test.xml"), handler);
    }
}