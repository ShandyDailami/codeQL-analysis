import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.LinkedList;
import java.util.List;

public class java_38824_XMLParser_A08 extends DefaultHandler {

    private List<String> securityData = new LinkedList<>();

    private boolean isSecurityElement = false;

    private StringBuilder currentValue = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("SecurityElement")) {
            isSecurityElement = true;
        }
        currentValue = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("SecurityElement")) {
            securityData.add(currentValue.toString());
            isSecurityElement = false;
        } else if (isSecurityElement) {
            currentValue.append(qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isSecurityElement) {
            currentValue.append(new String(ch, start, length));
        }
    }

    public List<String> getSecurityData() {
        return securityData;
    }
}