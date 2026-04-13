import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_26849_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack;
    private StringBuilder buffer;
    private boolean integrityFailure = false;

    public java_26849_XMLParser_A08() {
        elementStack = new Stack<>();
        buffer = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void endDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!elementStack.pop().equals(qName)) {
            integrityFailure = true;
            return;
        }

        if (integrityFailure) {
            System.out.println("Integrity Failure: " + buffer.toString());
            integrityFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        org.xml.sax.XMLReader xmlReader = org.xml.sax.SAXReader.newInstance();
        xmlReader.setContentHandler(parser);

        try {
            xmlReader.parse(Class.forName("A08_IntegrityFailure").getResourceAsStream("A08_IntegrityFailure.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}