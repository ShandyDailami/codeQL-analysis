import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_11467_XMLParser_A03 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private StringBuilder currentText = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);
        currentText.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("secureElement")) {
            String injection = (String) elementStack.pop();
            if (injection.startsWith("injection")) {
                System.out.println("Detected injection attempt");
            } else {
                System.out.println("No injection attempt found");
            }
        } else {
            elementStack.pop();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentText.append(ch, start, length);
    }
}