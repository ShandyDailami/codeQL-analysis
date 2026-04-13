import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_21271_XMLParser_A07 extends DefaultHandler {

    private List<String> authFailureList;
    private String currentElement;

    public java_21271_XMLParser_A07() {
        authFailureList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementContent = new String(ch, start, length).trim();
        if (!elementContent.isEmpty()) {
            if ("AuthFailure".equals(currentElement)) {
                authFailureList.add(elementContent);
            }
            currentElement = null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = null;
    }

    public List<String> getAuthFailureList() {
        return authFailureList;
    }
}