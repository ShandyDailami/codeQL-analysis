import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_21436_XMLParser_A07 extends DefaultHandler {
    private List<String> authFailures = new ArrayList<>();
    private String currentElement;

    public List<String> getAuthFailures() {
        return authFailures;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("authFailure".equals(currentElement)) {
            authFailures.add(localName);
        }
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ("authFailure".equals(currentElement)) {
            String value = new String(ch, start, length);
            authFailures.add(value);
        }
    }
}