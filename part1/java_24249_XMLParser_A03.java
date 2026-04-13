import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_24249_XMLParser_A03 extends DefaultHandler {

    private List<String> injectionList = new ArrayList<>();
    private StringBuilder data = new StringBuilder();
    private boolean isInjection = false;
    private static final String INJECTION_POINT = "<!--- Security-sensitive operations related to A03_Injection -->";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("tagName")) {
            isInjection = data.toString().contains(INJECTION_POINT);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isInjection) {
            injectionList.add(data.toString());
        }
        data.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    public List<String> getInjectionList() {
        return injectionList;
    }
}