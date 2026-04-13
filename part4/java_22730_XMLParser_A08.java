import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_22730_XMLParser_A08 extends DefaultHandler {

    private Stack<String> elementStack;
    private StringBuilder buffer;
    private boolean bName;
    private boolean bAuthor;
    private boolean bPrice;

    public java_22730_XMLParser_A08() {
        elementStack = new Stack<>();
        buffer = new StringBuilder();
        bName = bAuthor = bPrice = false;
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);

        if(qName.equals("book")) {
            bName = bAuthor = bPrice = true;
            System.out.println("Start of book : " + qName);
        } else if(qName.equals("name")) {
            bName = true;
        } else if(qName.equals("author")) {
            bAuthor = true;
        } else if(qName.equals("price")) {
            bPrice = true;
        }

        buffer.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();

        if(qName.equals("book")) {
            System.out.println("End of book : " + qName);
        } else if(qName.equals("name")) {
            bName = false;
        } else if(qName.equals("author")) {
            bAuthor = false;
        } else if(qName.equals("price")) {
            bPrice = false;
        }

        if(!elementStack.isEmpty()) {
            return;
        }

        if(bName) {
            System.out.println("Name : " + buffer.toString());
            bName = false;
        }
        if(bAuthor) {
            System.out.println("Author : " + buffer.toString());
            bAuthor = false;
        }
        if(bPrice) {
            System.out.println("Price : " + buffer.toString());
            bPrice = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }
}