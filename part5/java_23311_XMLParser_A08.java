import java.io.*;
import java.util.Stack;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_23311_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack;
    private StringBuilder buffer;

    public java_23311_XMLParser_A08() {
        elementStack = new Stack<>();
        buffer = new StringBuilder();
    }

    public void parse(String filename) throws IOException, SAXException {
        XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        reader.setContentHandler(this);
        reader.parse(new InputSource(new File(filename)));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        buffer.append("<").append(qName).append(">");
        if (!elementStack.isEmpty()) {
            buffer.append("</").append(elementStack.peek()).append(">");
        }
        System.out.println(buffer.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    public static void main(String[] args) throws IOException, SAXException {
        new XMLParser().parse("example.xml");
    }
}