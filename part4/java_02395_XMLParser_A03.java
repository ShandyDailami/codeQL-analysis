import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_02395_XMLParser_A03 extends DefaultHandler {

    private Stack<String> stack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();
    private boolean isInData = false;

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
        buffer.setLength(0);
        stack.push(qName);
        System.out.print("Start of element : " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        buffer.setLength(0);
        stack.pop();
        System.out.println("End of element : " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInData) {
            buffer.append(ch, start, length);
        }
    }

    public String getData() {
        return buffer.toString();
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning : " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("Error : " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error : " + e.getMessage());
    }

}