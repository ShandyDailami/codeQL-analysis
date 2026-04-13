import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13961_XMLParser_A03 extends DefaultHandler {
    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (isSecuritySensitiveOperation(qName)) {
            System.out.println("Found security-sensitive operation: " + qName);
        }
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isSecuritySensitiveOperation(qName)) {
            System.out.println("Found end of security-sensitive operation: " + qName);
        }
        lastElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && isSecuritySensitiveOperation(lastElement)) {
            System.out.println("Found security-sensitive operation in characters: " + new String(ch, start, length));
        }
    }

    private boolean isSecuritySensitiveOperation(String qName) {
        // implement logic to determine if the operation is security-sensitive
        // for example, a list of known operations or patterns
        return qName.equals("operation1") || qName.equals("operation2");
    }
}