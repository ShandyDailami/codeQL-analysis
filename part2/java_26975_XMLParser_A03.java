import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_26975_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String elementContent = new String(ch, start, length).trim();
        if (elementContent.isEmpty()) {
            return;
        }
        System.out.println("Character data: " + elementContent);
    }

    public static void main(String[] args) throws Exception {
        XmlSAXHandler saxHandler = new XmlSAXHandler();
        org.xml.sax.Parser parser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser(saxHandler);
        parser.parse(Class.forName("XmlFile").getResourceAsStream("/test.xml"), saxHandler);
    }
}