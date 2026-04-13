import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_13387_XMLParser_A03 extends DefaultHandler {
    private String currentElement;
    private Stack<String> stack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
        stack.push(currentElement);
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = qName;
        stack.pop();
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentElement.equals("Element")) { // replace with your own element name
            System.out.println("Character Data: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("your_xml_file.xml").getResourceAsStream(), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}