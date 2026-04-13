import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.Stack;

public class java_10801_XMLParser_A01 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private boolean isInElement = false;
    private StringBuilder content = new StringBuilder();

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        isInElement = true;
        content.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
        isInElement = false;
        if(elementStack.isEmpty()){
            System.out.println("End Element: " + qName + ", Content: " + content.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(isInElement){
            content.append(ch, start, length);
        }
    }
}