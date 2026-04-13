import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_26863_XMLParser_A07 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stack.push(qName);
        data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (AuthFailure.isSecuritySensitive(qName)) {
            // Handle the security sensitive operation here
        }
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    public String getResult() {
        return data.toString();
    }
}