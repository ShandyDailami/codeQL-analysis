import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_12094_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack;
    private String currentElement;
    private String currentText;
    
    public java_12094_XMLParser_A08() {
        elementStack = new Stack<>();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        elementStack.push(currentElement);
        currentText = "";
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (elementStack.peek().equals(qName)) {
            elementStack.pop();
            System.out.println(currentElement + ": " + currentText);
        } else {
            System.out.println("Error: Expected " + elementStack.peek() + ", got " + qName);
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentText += new String(ch, start, length);
    }
    
    public static void main(String[] args) throws Exception {
        String xml = "<books><book><title>Great Expectations</title><author>Charles Dickens</author></book><book><title>Oliver Twist</title><author>Charles Dickens</author></book></books>";
        XmlParser parser = new XmlParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, parser);
        saxParser.parse(new InputSource(new StringReader(xml)), true);
    }
}