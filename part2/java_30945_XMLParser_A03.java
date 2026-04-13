import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_30945_XMLParser_A03 extends DefaultHandler {

    private List<String> securitySensitiveOperations = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (isSecuritySensitiveOperation(qName)) {
            securitySensitiveOperations.add(qName);
        }
    }

    private boolean isSecuritySensitiveOperation(String operation) {
        // Here you can implement your security checks. For example, you can use a HashSet or a database
        // to store known security sensitive operations and then check if the operation is in this set.
        // This is just a placeholder and actual implementation may be more complex.
        return operation.equals("operation1") || operation.equals("operation2");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Not implemented in this example
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Not implemented in this example
    }

    public List<String> getSecuritySensitiveOperations() {
        return securitySensitiveOperations;
    }
}