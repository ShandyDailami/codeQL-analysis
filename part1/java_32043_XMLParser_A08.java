import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_32043_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private boolean isTitleElement = false;
    private boolean isLinkElement = false;
    private String lastElement = "";

    @Override
    public void startDocument() {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);

        if(qName.equals("bookstore") || qName.equals("book")) {
            isTitleElement = true;
            isLinkElement = true;
        } else if(isTitleElement) {
            if(qName.equals("title")) {
                isTitleElement = false;
            }
        } else if(isLinkElement) {
            if(qName.equals("link")) {
                isLinkElement = false;
            }
        }

        lastElement = qName;
        printElement(qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        lastElement = qName;

        if(isTitleElement && !qName.equals("title")) {
            isTitleElement = false;
        } else if(isLinkElement && !qName.equals("link")) {
            isLinkElement = false;
        }

        printElement(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(isTitleElement || isLinkElement) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }
    }

    private void printElement(String qName, Attributes attributes) {
        System.out.println("Element: " + qName + ", Attributes: " + attributes);
    }
}