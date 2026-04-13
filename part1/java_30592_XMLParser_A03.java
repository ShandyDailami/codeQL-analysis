import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_30592_XMLParser_A03 extends DefaultHandler {
    private String lastTag = "";
    private List<String> injectionList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (isSecuritySensitiveOperation(qName)) {
            injectionList.add(qName);
        }
        lastTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTag.equals(qName) && isSecuritySensitiveOperation(qName)) {
            injectionList.add(new String(ch, start, length));
        }
    }

    private boolean isSecuritySensitiveOperation(String qName) {
        // Add your logic to determine whether qName is a security sensitive operation here
        // For this example, I will return false
        return false;
    }

    public List<String> getInjectionList() {
        return injectionList;
    }
}