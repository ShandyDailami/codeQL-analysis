import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_10039_XMLParser_A03 extends DefaultHandler {

    private List<String> injectionSensitiveData = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (isInjectionSensitive(qName)) {
            String data = attributes.getValue("data");
            if (data != null) {
                injectionSensitiveData.add(data);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Nothing to do here.
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        // Nothing to do here.
    }

    private boolean isInjectionSensitive(String qName) {
        // This method checks if a string is potentially a security-sensitive data. 
        // For simplicity, we'll just return true for some common elements.
        return qName.equals("element1") || qName.equals("element2");
    }

    public List<String> getInjectionSensitiveData() {
        return injectionSensitiveData;
    }
}