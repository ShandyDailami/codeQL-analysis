import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_40956_XMLParser_A03 extends DefaultHandler {

    private Stack<String> tagStack = new Stack<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagStack.push(qName);
        printTags();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tagStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!tagStack.isEmpty()) {
            String content = new String(ch, start, length);
            printTags();
            System.out.println("Content: " + content);
        }
    }

    private void printTags() {
        System.out.print("In tags: ");
        for (String tag : tagStack) {
            System.out.print(tag + " ");
        }
        System.out.println();
    }
}