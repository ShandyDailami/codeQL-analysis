import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_33770_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();
    private boolean isIntrAuditFailure = false;
    private boolean isAuditFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);

        if ("IntegrityFailure".equals(qName)) {
            isIntrAuditFailure = true;
        }

        if (isIntrAuditFailure && "AuditFailure".equals(qName)) {
            isAuditFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();

        if ("IntegrityFailure".equals(qName)) {
            isIntrAuditFailure = false;
        }

        if (isIntrAuditFailure && "AuditFailure".equals(qName)) {
            isAuditFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String nodeValue = new String(ch, start, length).trim();

        if (isAuditFailure && !nodeValue.isEmpty()) {
            System.out.println("Security violation detected: " + nodeValue);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyXMLParser xmlParser = new MyXMLParser(new MyXMLHandler());
        xmlParser.parse(getClass().getResourceAsStream("/path/to/your/xml/file.xml"));
    }
}